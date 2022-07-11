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
                this.suma = suma;
                this.nuo = nuo;
                this.iki = iki;
            }

            @Override
            public void run() {
                System.out.println("Pradedam ");
                int counter = 10000;
                int threadNumber = 1;
                for (int i = nuo; i <= iki; i++) {
                    suma = suma + i;
                    if (i == counter) {
                        counter = counter + 10000;
                        Thread tn = new Skaiciai(i, iki,String.valueOf(threadNumber + "threadas"));
                        System.out.println(threadNumber + "-as threadas, suma: " + suma);
                        threadNumber++;
                    }
                }
                System.out.println("Pabaigem ");
            }
        }
        Thread t1 = new Skaiciai(nuo, iki, String.valueOf(0 + "threadas"));
        t1.start();
    }
}
