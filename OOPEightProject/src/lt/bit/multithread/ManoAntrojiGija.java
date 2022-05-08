package lt.bit.multithread;

public class ManoAntrojiGija implements Runnable{

    private Printer printer;

    public ManoAntrojiGija(Printer printer){
        this.printer = printer;
    }

    @Override
    public void run() {
//        System.out.println("Veikia ir cia!");
        printer.print(100);
    }
}
