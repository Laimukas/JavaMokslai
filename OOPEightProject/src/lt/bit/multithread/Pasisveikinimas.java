package lt.bit.multithread;

public class Pasisveikinimas  {

    private final String tekstas = "Labas";
    private final String tekstas2 = "hello";

    public void sayHello() throws InterruptedException {
        // Tipinis deadlock pavyzdis
        synchronized (tekstas){
            System.out.println("Edvinai, " + tekstas);
        }

        Thread.sleep(1000);
        synchronized (tekstas2){
            System.out.println("Edvinai, " + tekstas2);
        }
    }
}
