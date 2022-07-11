package lt.bit.penkt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    //Destytojo varijantas rodantis dir esancius failus,galimybe ieiti i nauja dir ir gryzti,bei dar paduoti papildomus parametrus po ?

    public static final String SERVER_STOP = "/stop";

    public static final String WEB_DIR = "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\21sav\\src\\lt\\bit\\penkt";
    private static final File webDirFile = new File(WEB_DIR);

    public static void main(String[] args) {
        try (
                ServerSocket sc = new ServerSocket(8888);
        ) {
            boolean run = true;
            while (run) {
                Socket socket = sc.accept();
                try (
                        InputStream is = socket.getInputStream();
                        Reader r = new InputStreamReader(is, "UTF-8");
                        BufferedReader br = new BufferedReader(r);
                        OutputStream os = socket.getOutputStream();
                        Writer w = new OutputStreamWriter(os, "UTF-8");
                        BufferedWriter bw = new BufferedWriter(w);
                ) {
//                    String line;
//                    while ( (line = br.readLine()) != null && !line.equals("")) {
//                        System.out.println(line);
//                    }
                    String requestLine = br.readLine();
                    if (requestLine != null) {
                        System.out.println(requestLine);
                        String[] parts = requestLine.split(" ");
                        if (parts.length == 3) {
                            String resourceName = parts[1];
                            Map<String, String> p = new HashMap();
                            // jei requeste yra nurodyti parametrai
                            if (resourceName.contains("?")) {
                                // parametrai nurodomi po ?
                                String params = resourceName.substring(resourceName.indexOf("?") + 1);
                                // paimam "svaru" resurso pavadinima (pries klaustuka)
                                resourceName = resourceName.substring(0, resourceName.indexOf("?"));
                                // parametrai gali buti keli (atskirti &)
                                String[] singleParam = params.split("&");
                                for (String sp : singleParam) {
                                    // ne visi parametrai turi reiksme
                                    if (sp.contains("=")) {
                                        // parametras turi reiksme pavadinimas=reiksme
                                        // parametro pavadinimas (iki lygybes)
                                        String pName = sp.substring(0, sp.indexOf("="));
                                        // parametro reiksme (po lygybes)
                                        String pValue = sp.substring(sp.indexOf("=") + 1);
                                        p.put(pName, pValue);
                                    } else {
                                        // parametras neturi reiksmes tiesiog_pavadinimas
                                        // traktuojam, kad reiksme tokiu atveju yra null
                                        p.put(sp, null);
                                    }
                                }
                            }
                            if (SERVER_STOP.equals(resourceName)) {
                                run = false;
                                bw.write("HTTP/1.1 200 OK\r\n");
                                bw.write("Content-Type: text/html\r\n");
                                bw.write("\r\n");
                                bw.write("<html>\r\n");
                                bw.write("<body>\r\n");
                                bw.write("<h1>Server is shutting down. Bye.</h1>\r\n");
                                bw.write("</body>\r\n");
                                bw.write("</html>\r\n");
                                bw.write("\r\n");
                            } else {
                                File f = new File(webDirFile, resourceName);
                                f = f.toPath().normalize().toFile();
                                if (f.isDirectory()) {
                                    bw.write("HTTP/1.1 200 OK\r\n");
                                    bw.write("Content-Type: text/html\r\n");
                                    bw.write("\r\n");
                                    bw.write("<html>\r\n");
                                    bw.write("<body>\r\n");
                                    // ".." reiskia -> eiti i tevine direktorija
                                    File fUp = new File(f, "..");
                                    fUp = fUp.toPath().normalize().toFile();
                                    // paziurim ar nebando islysti auksciau nei musu WEB_DIR
                                    if (fUp.toPath().getNameCount() >= webDirFile.toPath().getNameCount()) {
                                        String href = fUp.getAbsolutePath().substring(WEB_DIR.length());
                                        bw.write(
                                                "<a href=\"" + ("".equals(href) ? "/" : href) + "\">" +
                                                        ".." +
                                                        "</a>" +
                                                        "<br>" +
                                                        "\r\n"
                                        );
                                    }
                                    File[] listFiles = f.listFiles();
                                    // jei reikia, rusiuojam failu sarasa
                                    if ("asc".equalsIgnoreCase(p.get("sort"))) {
                                        Arrays.sort(listFiles, (f1, f2) -> {
                                            return f1.getName().compareTo(f2.getName());
                                        });
                                    } else if ("desc".equalsIgnoreCase(p.get("sort"))) {
                                        Arrays.sort(listFiles, (f1, f2) -> {
                                            return f2.getName().compareTo(f1.getName());
                                        });
                                    }
                                    // jei nurodyta, kad direktorijas reikia atspausdinti priekyje/gale
                                    if ("first".equalsIgnoreCase(p.get("dir"))) {
                                        printFiles(listFiles, bw, true);
                                        printFiles(listFiles, bw, false);
                                    } else if ("last".equalsIgnoreCase(p.get("dir"))) {
                                        printFiles(listFiles, bw, false);
                                        printFiles(listFiles, bw, true);
                                    } else {
                                        // spausdinam visa failu sarasa
                                        printFiles(listFiles, bw, null);
                                    }
                                    bw.write("</body>\r\n");
                                    bw.write("</html>\r\n");
                                    bw.write("\r\n");
                                } else {
                                    try (
                                            InputStream fis = new FileInputStream(f);
                                            Reader fr = new InputStreamReader(fis, "UTF-8");
                                            BufferedReader fbr = new BufferedReader(fr);
                                    ) {
                                        bw.write("HTTP/1.1 200 OK\r\n");
                                        bw.write("Content-Type: text/html\r\n");
                                        bw.write("\r\n");
                                        String fl;
                                        while ( (fl = fbr.readLine()) != null) {
                                            bw.write(fl + "\r\n");
                                        }
                                    }
                                    catch (FileNotFoundException ex) {
                                        bw.write("HTTP/1.1 404 Not Found\r\n");
                                        bw.write("\r\n");
                                    }
                                }
                            }
                            bw.flush();
                        }
                    }
                }
                catch (IOException ex) {
                    System.err.println("Failed to read from input stream: " + ex.getMessage());
                }
            }
        }
        catch (IOException ex) {
            System.err.println("Failed to open server port: " + ex.getMessage());
        }
    }

    public static void printFiles(File[] listFiles, BufferedWriter bw, Boolean dirs) throws IOException {
        for (File fileInDir : listFiles) {
            if (dirs == null || (dirs && fileInDir.isDirectory())  || (!dirs && !fileInDir.isDirectory())) {
                String href = fileInDir.getAbsolutePath();
                href = href.substring(WEB_DIR.length());
                bw.write(
                        "<a href=\"" + href + "\">" +
                                fileInDir.getName() +
                                "</a>" +
                                "<br>" +
                                "\r\n"
                );
            }
        }
    }
}
