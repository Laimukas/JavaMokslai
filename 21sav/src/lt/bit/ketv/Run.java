package lt.bit.ketv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
public class Run {

    //*******Naudojam metoda serverio stabdymui******
    public static final String SERVER_STOP = "/stop";

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
                                bw.write("HTTP/1.1 200 OK\r\n");
                                bw.write("Content-Type: text/html\r\n");
                                bw.write("\r\n");
                                bw.write("<html>\r\n");
                                bw.write("<body>\r\n");
                                bw.write("<h1>Hello World !!!</h1>\r\n");
                                bw.write("<h1>Labas pasauli !!!</h1>\r\n");
                                bw.write("<img src=\"http://www.balionunamai.lt/c/30-category/balionai-su-heliu.jpg\"><img>\r\n");
                                bw.write("</body>\r\n");
                                bw.write("</html>\r\n");
                                bw.write("\r\n");
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

}