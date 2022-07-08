package lt.bit.penkt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    //*******Naudojam metoda serverio stabdymui******
    public static final String SERVER_STOP = "/stop";

    public static final String WEB_DIR = "src/lt/bit/penkt";

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
                                File f = new File(WEB_DIR + resourceName);
//                                System.out.println("resourceName: "+resourceName);
//                                System.out.println(parts);
//                                System.out.println("toPath: "+f.toPath());
//                                System.out.println("Path: "+f.getPath());
//                                System.out.println("AbsolutePath: "+f.getAbsolutePath());
//                                System.out.println("getAbsoluteFile"+f.getAbsoluteFile());
                                if (f.isDirectory()) {
                                    bw.write("HTTP/1.1 200 OK\r\n");
                                    bw.write("Content-Type: text/html\r\n");
                                    bw.write("\r\n");
                                    bw.write("<html>\r\n");
                                    bw.write("<head>\n" +
                                            "    <style>\n" +
                                            "h1 {text-align: center;}\n" +
                                            "h3 {text-align: center;}\n" +
                                            "p {text-align: center;}\n" +
                                            "</style>\n" +
                                            "</head>");
                                    bw.write("<body>\r\n");
                                    for (File fileInDir : f.listFiles()) {
                                        // tiesiog isgaunam failu pavadinimus direktorijoj
//                                        bw.write(fileInDir.getName()+"\n");
                                        // linkus kuriam is failu esanciu direktorijoj
                                        bw.write("<p><a href=\"" + fileInDir.getName() + "\">" + fileInDir.getName() + "</p></a>\r\n");
//                                        bw.write("<h6>Path</h6>\r\n");
//                                        bw.write(fileInDir.getPath());
//                                        bw.write("<h6>Absolute Path</h6>\r\n");
//                                        bw.write(fileInDir.getAbsolutePath());
//                                        bw.write("<p>Web_Dir: "+WEB_DIR+"<h1>*</h1>" +" resourceName: "+resourceName+"<h1>*</h1>" +",cia dar resourceLine: "+requestLine+"<h1>*</h1>" +"</p>\r\n");
                                        bw.write("<p>------------------------</p>\r\n");

                                    }
                                    bw.write("</body>\r\n");
                                    bw.write("</html>\r\n");
                                    bw.write("\r\n");
                                    String TEMP_PATH = WEB_DIR + resourceName;
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

                                        while ((fl = fbr.readLine()) != null) {
                                            bw.write(fl + "\r\n");
                                        }
                                    } catch (FileNotFoundException ex) {
                                        bw.write("HTTP/1.1 404 Not Found\r\n");
                                        bw.write("\r\n");
                                    }
                                }
                            }
                            bw.flush();
                        }
                    }
                } catch (IOException ex) {
                    System.err.println("Failed to read from input stream: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Failed to open server port: " + ex.getMessage());
        }
    }
}
