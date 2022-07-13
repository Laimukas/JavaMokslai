package lt.bit.trec;

import java.text.SimpleDateFormat;
import java.util.*;

public class Run2 {
    public static void main(String[] args) {
        class MusioLaukas {
            int a = 0;
            int b = 0;

            @Override
            public String toString() {
                return "{" + "a=" + a + ", b=" + b + '}';
            }

        }

        MusioLaukas ml = new MusioLaukas();
        MusioLaukas ml2 = new MusioLaukas();

        Thread tUp = new Thread(() -> {
            while (ml.a < 100) {
                synchronized (ml) {
                    synchronized (ml2) {
                        ml.a++;
                        ml.b++;
                        ml2.a++;
                        ml2.b++;
                        System.out.println("tUp: " + ml);
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    // ignore
                }
            }
            System.out.println("tUp pabaige");
        });
        Thread tDown = new Thread(() -> {
            while (ml.a > -100) {
                synchronized (ml) {
                    synchronized (ml2) {
                        ml.a--;
                        ml.b--;
                        ml2.a--;
                        ml2.b--;
                        System.out.println("tDown: " + ml);
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    // ignore
                }
            }
            System.out.println("tDown pabaige");
        });
        tUp.start();
        tDown.start();
    }

    public static void main5(String[] args) {
        System.out.println("Pradedam");
        try {
            Thread.sleep(3000); // miegos tiek milisekundziu ( t.y. 3 sekundes )
        } catch (InterruptedException ex) {
            // ignore
        }
        System.out.println("Pabaiga");
    }

    public static void main4(String[] args) {
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

    public static void main3(String[] args) {
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

    public static void main2(String[] args) {

        class Skaiciai extends Thread {
            String pavadinimas;
            int nuo;
            int iki;

            public Skaiciai(String pavadinimas, int nuo, int iki) {
                this.pavadinimas = pavadinimas;
                this.nuo = nuo;
                this.iki = iki;
            }

            @Override
            public void run() {
                System.out.println("Pradedam " + this.pavadinimas);
                for (int i = nuo; i <= iki; i++) {
                    System.out.println(this.pavadinimas + ": " + i);
                }
                System.out.println("Pabaigem " + this.pavadinimas);
            }
        }

        class Skaiciukai implements Runnable {

            String pavadinimas;
            int nuo;
            int iki;

            public Skaiciukai(String pavadinimas, int nuo, int iki) {
                this.pavadinimas = pavadinimas;
                this.nuo = nuo;
                this.iki = iki;
            }

            @Override
            public void run() {
                System.out.println("Pradedam " + this.pavadinimas);
                for (int i = nuo; i <= iki; i++) {
                    System.out.println(this.pavadinimas + ": " + i);
                }
                System.out.println("Pabaigem " + this.pavadinimas);
            }

        }

        System.out.println("pradzia");
        Thread t1 = new Skaiciai("Pirmas", 1, 20);
        Thread t2 = new Skaiciai("Antras", 1, 20);
        Skaiciukai sk = new Skaiciukai("Trecias", 1, 20);
        Thread t3 = new Thread(sk);
        Thread t4 = new Thread(new Runnable() {
            String pavadinimas = "Ketvirtas";
            int nuo = 1;
            int iki = 20;
            @Override
            public void run() {
                System.out.println("Pradedam " + this.pavadinimas);
                for (int i = nuo; i <= iki; i++) {
                    System.out.println(this.pavadinimas + ": " + i);
                }
                System.out.println("Pabaigem " + this.pavadinimas);
            }
        });
        Thread t5 = new Thread(() -> {
            String pavadinimas = "Penktas";
            int nuo = 1;
            int iki = 20;
            System.out.println("Pradedam " + pavadinimas);
            for (int i = nuo; i <= iki; i++) {
                System.out.println(pavadinimas + ": " + i);
            }
            System.out.println("Pabaigem " + pavadinimas);
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        for (int i = 1; i <= 50; i++) {
            System.out.println("main: " + i);
        }
        System.out.println("pabaiga");
    }

}


/*
Parasyti programa, kuri skaiciuoja skaiciu sumas:
ivedam nuo ir iki

suskaldom rezi kas 10000 ir paleidziam atskirus Thread'us su savo nuo/iki
kiekvienas Thread'as pabaigoje atspausdina skaiciu nuo/iki suma

*/

/*
Sraigiu lenktynes:

Sliauzia 10 sriagiu.

Reikia nusliauzti 3 metrus.
Kiekviena sraige pasliauzia (random) 2-10 cm ir po to pamiega (random) 1-3 sekundes
Kas 50 cm sraige pasako (atspausdina i ekrana) savo pavadinima ir kiek ji nusliauze.

Po to kai visos sraiges pabaige distancija,
reikia surusiuoti visas sraiges pagal distancijos iveikimo laika ir
atspausdinti turnyrine lentele.



*/