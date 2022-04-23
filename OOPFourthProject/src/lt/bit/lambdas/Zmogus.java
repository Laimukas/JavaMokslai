package lt.bit.lambdas;

public class Zmogus {

    private String vardas;
    private int amzius;
    private Lytis lytis;

    public Zmogus(String vardas, int amzius, Lytis lytis) {
        this.vardas = vardas;
        this.amzius = amzius;
        this.lytis = lytis;
    }

    public String getVardas() {
        return vardas;
    }

    public int getAmzius() {
        return amzius;
    }

    public Lytis getLytis() {
        return lytis;
    }
}
