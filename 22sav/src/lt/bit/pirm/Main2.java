package lt.bit.pirm;
//Parasyti programa, kuri skaiciuoja skaiciu sumas:
//ivedam nuo ir iki
//
//suskaldom rezi kas 10000 ir paleidziam atskirus Thread'us su savo nuo/iki
//kiekvienas Thread'as pabaigoje atspausdina skaiciu nuo/iki suma

//MANO

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nuo: ");
        int nuo = Integer.parseInt(scanner.nextLine());
        System.out.print("Iki: ");
        int iki = Integer.parseInt(scanner.nextLine());

        class Skaiciai extends Thread {
            String name;
            int suma;
            int nuo;
            int iki;

            public Skaiciai(int nuo, int iki, String name) {
                this.name = name;
                this.suma = 0;
                this.nuo = nuo;
                this.iki = iki;
            }

            @Override
            public void run() {
//                System.out.println("Pradedam ");

                for (int i = nuo; i <= iki; i++) {
                    suma = suma + i;

                }
                System.out.println("Pabaigem " + this.name + ", nuo: " + nuo + ", iki: " + iki + ", jo suma: " + suma);
            }
        }
//        Thread t1 = new Skaiciai(nuo, iki, String.valueOf(0 + " threadas"));
//        t1.start();
        if ((iki - nuo) > 10000) {
            int skaicius = 1;
            do {
                int skaiciusIKII = nuo + 9999;
                if (skaiciusIKII > iki) {
                    skaiciusIKII = iki;
                }
                Skaiciai skaiciai = new Skaiciai(nuo, skaiciusIKII, String.valueOf(skaicius + "-as threadas"));
                skaiciai.start();
                nuo = nuo + 10000;

                skaicius++;
            } while (nuo <= iki);
        } else {
            System.out.println("Per mazas skaiciu rezis");
// nuo 17 iki 48315
            // 1  nuo 17 iki 10016
            // 2  nuo 10017 iki 20016
            // 3 nuo 20017 iki 30016
            // 4 nuo 30017 iki 40016
            // 5 nuo 40017 iki 48315
        }
    }
}
