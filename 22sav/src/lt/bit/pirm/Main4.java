package lt.bit.pirm;

import java.util.Scanner;

public class Main4 {
    // destytojo Aliaus padaryta uzduotis,cia dar ir sumuotojo klase priklauso is kurios metodas paimtas
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ivesk nuo: ");
        long nuo = sc.nextLong();
        System.out.println("Ivesk iki: ");
        long iki = sc.nextLong();
        System.out.println("Kas kiek: ");
        long kiek = sc.nextLong();
//        long kiek = 10000;
        while (nuo <= iki) {
//            Thread t = new Sumuotojas(nuo, nuo + (kiek - 1) < iki ? nuo + (kiek - 1) : iki);
            long tarpinisIki = nuo + (kiek - 1);
            if (tarpinisIki > iki) {
                tarpinisIki = iki;
            }
            Thread t = new Sumuotojas(nuo, tarpinisIki);
            t.start();
//            try {
//                Thread.sleep(3000); // miegos tiek milisekundziu ( t.y. 3 sekundes )
//            } catch (InterruptedException ex) {
//                // ignore
//            }
            nuo += kiek;
        }
    }
}
