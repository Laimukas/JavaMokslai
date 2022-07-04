package lt.bit.io;

import java.io.*;
import java.nio.charset.Charset;

public class Run {

    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("a.txt");
                Reader r = new InputStreamReader(fis, "UTF-8");
        ) {
            int b;
            while ((b = r.read()) != -1) {
                System.out.println(b);
            }
            if (Math.random() < 1) {
                throw new RuntimeException("test");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println("suveiks pries uzdarant streamus");
        }
    }

    public static void main1(String[] args) {
        System.out.println("pradedam");
        FileInputStream fis = null;
        Reader r = null;
        try {
            fis = new FileInputStream("a.txt");
            r = new InputStreamReader(fis, "UTF-8");
            int b;
            while ((b = r.read()) != -1) {
                System.out.println(b);
            }
//            if (Math.random() < 1) {
//                throw new RuntimeException("test");
//            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (r != null) {
                System.out.println("uzdarom readeri");
                try {
                    r.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
            if (fis != null) {
                System.out.println("uzdarom faila");
                try {
                    fis.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }
        System.out.println("pabaiga");
    }

    public static void main2(String[] args) {

        System.out.println("Pradedam skaityti faila");
        try  {
//            FileInputStream fis = new FileInputStream("D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\21sav\\src\\lt\\bit\\io\\a.txt");
//            Reader r = new InputStreamReader(fis, "UTF-8");
            //su sekancia FileReader eilute padarom ta pati ka su ankstesnem dviem

            //***********JEI ATIDAREI STRYMA TAI JI BUTINAI REIK IR UZDARYT**********************

            FileReader r = new FileReader("src/lt/bit/io/utf16le.txt", Charset.forName("UTF-16"));//esmeje reik
            // zinot kaip failas koduotas ir kaip ji reik nuskaitinet,nes jei klysim,negausim reikiamo rezultato(cia del to UTF-8 ar UTF-16 ar dar buna net UTF-32)
            BufferedReader br = new BufferedReader(r);
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
//            int charCode;
//            while ((charCode = r.read()) != -1) {
//                char c = (char) charCode;
//                System.out.println(charCode + " - " + c);
//            }
//            int b;
//            while ((b = fis.read()) != -1) {
//                char c = (char) b;
//                System.out.println(b + " - " + c);
//            }
            System.out.println("Failas perskaitytas");
            r.close();
//            fis.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
//        Scanner sc = new Scanner(System.in);
//
//        int sk1 = sc.nextInt();
//        int sk2 = sc.nextInt();
//        int sk3 = sk1 + sk2;
//
//        System.out.println(sk3);
//
//        System.err.println("labas pasauli");

    }
}
