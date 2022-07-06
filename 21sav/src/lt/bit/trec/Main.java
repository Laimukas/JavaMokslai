package lt.bit.trec;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    // **********PASKAITA***************
    // **********SERVERIAI**************
    public static void main(String[] args) {
        try (
                ServerSocket sc = new ServerSocket(8888);
        ) {
            Socket socket = sc.accept();
            try (
                    InputStream is = socket.getInputStream();
                    Reader r = new InputStreamReader(is, "UTF-8");
                    BufferedReader br = new BufferedReader(r);
                    OutputStream os = socket.getOutputStream();
                    Writer w = new OutputStreamWriter(os, "UTF-8");
                    BufferedWriter bw = new BufferedWriter(w);
            ) {
                String line;
                while ( (line = br.readLine()) != null && !line.equals("")) {
                    System.out.println(line);
                }
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
                bw.flush();
            }
            catch (IOException ex) {
                System.err.println("Failed to read from input stream: " + ex.getMessage());
            }
        }
        catch (IOException ex) {
            System.err.println("Failed to open server port: " + ex.getMessage());
        }
    }
}
