package lt.bit.trec;

public class Sumuotojas extends Thread {

    private long nuo;
    private long iki;
    private long suma;

    public Sumuotojas(long nuo, long iki) {
        this.nuo = nuo;
        this.iki = iki;
        this.suma = 0;
    }

    public long getNuo() {
        return nuo;
    }

    public long getIki() {
        return iki;
    }

    public long getSuma() {
        return suma;
    }

    @Override
    public void run() {
        for (long i = nuo; i <= iki; i++) {
            suma += i;
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Sumuotojas{" + "nuo=" + nuo + ", iki=" + iki + ", suma=" + suma + '}';
    }

}
