package lt.bit.multithread;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();

        ManoGija manoGija = new ManoGija(printer);
        manoGija.start();

        Thread manoAntrojiGija = new Thread(new ManoAntrojiGija(printer));
        manoAntrojiGija.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Veikia ir is sito!");
            }
        };

        Thread manoTreciojiGija = new Thread(runnable);
        manoTreciojiGija.start();

//        DeadLock pvz
//        Pasisveikinimas pasisveikinimas = new Pasisveikinimas();
//        ManoTreciaGija manoTreciaGija = new ManoTreciaGija(pasisveikinimas);
//        ManoKetvirtaGija manoKetvirtaGija = new ManoKetvirtaGija(pasisveikinimas);
//        manoTreciaGija.start();
//        manoKetvirtaGija.start();


        // vykdoma tada, kai aplikacija išsijunginėja.
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new ManoPenktojiGija());
    }
}
