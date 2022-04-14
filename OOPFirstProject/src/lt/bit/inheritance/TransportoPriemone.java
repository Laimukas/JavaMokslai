package lt.bit.inheritance;

public class TransportoPriemone {

    private int ratuSkaicius;
    private double svoris;
    private int aukstis;

    public TransportoPriemone(int ratuSkaicius, double svoris, int aukstis) {
        this.ratuSkaicius = ratuSkaicius;
        this.svoris = svoris;
        this.aukstis = aukstis;
    }

    public int getRatuSkaicius() {
        return ratuSkaicius;
    }

    public double getSvoris() {
        return svoris;
    }

    public int getAukstis() {
        return aukstis;
    }
}
