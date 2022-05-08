package lt.bit.multithread;

public class ManoKetvirtaGija extends Thread{

    private Pasisveikinimas pasisveikinimas;

    public ManoKetvirtaGija(Pasisveikinimas pasisveikinimas){
        this.pasisveikinimas = pasisveikinimas;
    }

    @Override
    public void run() {
        try {
            pasisveikinimas.sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
