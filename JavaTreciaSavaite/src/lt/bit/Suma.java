package lt.bit;

public class Suma {
    private int pirmasSkaicius;
    private int antrasSkaicius;

    public Suma(int pirmasSkaicius, int antrasSkaicius) {
        this.pirmasSkaicius = pirmasSkaicius;
        this.antrasSkaicius = antrasSkaicius;
    }


    @Override
    public String toString() {
        return "Skaiciau "+pirmasSkaicius+ " ir "+antrasSkaicius+" suma yra: "+ (pirmasSkaicius + antrasSkaicius);
    }
}
