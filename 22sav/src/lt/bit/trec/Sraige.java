package lt.bit.trec;

import java.util.Date;

public class Sraige  extends Thread {

    private String vardas;
    private int distancija;
    private int ratoIlgis;
    private Date start;
    private Date finish;

    public Sraige(String vardas) {
        this(vardas, 300);
    }
    public Sraige(String vardas, int distancija) {
        this(vardas, distancija, 50);
    }

    public Sraige(String vardas, int distancija, int ratoIlgis) {
        this.vardas = vardas;
        this.distancija = distancija;
        this.ratoIlgis = ratoIlgis;
        this.start = null;
        this.finish = null;
    }

    @Override
    public void run() {
        this.start = new Date();
        System.out.println("Sraige " + this.vardas + " staruoja");
        int kelias = 0;
        int ratas = 1;
        while (kelias < this.distancija) {
            kelias += random(2, 10);
            try {
                Thread.sleep(random(100, 300));
            } catch (InterruptedException ex) {
                // ignore
            }
            if (kelias > ratas * this.ratoIlgis) {
                System.out.println("Sraige " + this.vardas + " nusliauze " + kelias);
                ratas++;
            }
        }
        System.out.println("Sraige " + this.vardas + " finisavo");
        this.finish = new Date();
    }

    public static int random(int nuo, int iki) {
        return (int) (Math.random() * (iki - nuo) + nuo);
    }

    public long getLaikas() {
        if (this.start == null || this.finish == null) {
            return Long.MAX_VALUE;
        }
        return this.finish.getTime() - this.start.getTime();
    }

    @Override
    public String toString() {
        return "Sraige{" + "vardas=" + vardas + ", laikas=" + this.getLaikas() + '}';
    }


}
