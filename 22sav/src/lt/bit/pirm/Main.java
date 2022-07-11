package lt.bit.pirm;

public class Main {

    public static void main(String[] args) {

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
//        t1.run(); //cia tiesiog metodo iskvietimas
//        t2.run();
        t1.start();//cia jau yra paleidziamas thredas su start
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
