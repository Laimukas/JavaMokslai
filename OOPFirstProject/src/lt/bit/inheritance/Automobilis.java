package lt.bit.inheritance;

public class Automobilis extends TransportoPriemone {

    private double varikloTuris;

    public Automobilis(int ratuSkaicius, double svoris, int aukstis, double varikloTuris) {
        super(ratuSkaicius, svoris, aukstis);
        this.varikloTuris = varikloTuris;
    }

    public double getVarikloTuris(){
        return varikloTuris;
    }
}
