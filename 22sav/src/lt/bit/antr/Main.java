package lt.bit.antr;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1999);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 16);
        cal.set(Calendar.HOUR, 9);
        cal.set(Calendar.MINUTE, 50);
        cal.set(Calendar.SECOND, 30);
        cal.set(Calendar.MILLISECOND, 123);
        System.out.println(cal.getClass().getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss");
        System.out.println(sdf.format(cal.getTime()));
        cal.add(Calendar.MONTH, 15);
        cal.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(sdf.format(cal.getTime()));
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        /*
        2022 % 4 != 0 nekeliamieji
        2020 % 4 == 0 keliamieji
        2200 % 4 == 0, % 100 == 0, % 400 != 0 nekeliamieji
        2100 % 4 == 0, % 100 == 0, % 400 != 0 nekeliamieji
        2000 % 4 == 0, % 100 == 0, % 400 == 0 keliamieji
        1900 % 4 == 0, % 100 == 0, % 400 != 0 nekeliamieji
        1800 % 4 == 0, % 100 == 0, % 400 != 0 nekeliamieji
        */
    }

    public static void main2(String[] args) {
        //cia dar ir susumuoja visu threadu galutines sumas
        Scanner sc = new Scanner(System.in);
        System.out.println("Ivesk nuo: ");
        long nuo = sc.nextLong();
        System.out.println("Ivesk iki: ");
        long iki = sc.nextLong();
        System.out.println("Kas kiek: ");
        long kiek = sc.nextLong();
        //        long kiek = 10000;
        List<Sumuotojas> workers = new ArrayList();
        while (nuo <= iki) {
//            Thread t = new Sumuotojas(nuo, nuo + (kiek - 1) < iki ? nuo + (kiek - 1) : iki);
            long tarpinisIki = nuo + (kiek - 1);
            if (tarpinisIki > iki) {
                tarpinisIki = iki;
            }
            Sumuotojas t = new Sumuotojas(nuo, tarpinisIki);
            t.start();
            workers.add(t);
            nuo += kiek;
        }
        for (Sumuotojas worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException ex) {
                // ignored
            }
        }
        long totalSum = 0;
        for (Sumuotojas worker : workers) {
            totalSum += worker.getSuma();
        }
        System.out.println("Bendra suma: " + totalSum);
    }
}
