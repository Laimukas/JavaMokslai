package lt.bit.antr;

import java.io.*;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        //ivesti failo varda (is kur)
        //ivesti failo varda (i kur) - !!! DEMESIO !!! failas bus perrasytas
        //
        //nukopijuoti failo (is) turini i failo (i) turini
        System.out.println("Nuo kurio failo norite skaityti info?");
        Scanner sc = new Scanner(System.in);
        String nuskaitomasFailas = sc.next();
        System.out.println("Kuriam faile norite issaugoti info?");
        String issaugomasFailas = sc.next();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        System.out.println("Pradedam skaityti faila");

        try {

            fis = new FileInputStream(nuskaitomasFailas);
            fos = new FileOutputStream(issaugomasFailas);
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            System.out.println("nuskaitem ir irasem info!");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
