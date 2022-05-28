package exercises.kates;

public class Kate {

    private String vardas;
    private String veisle;
    private String lytis;
    private double svoris;
    private int amzius;

    public Kate(String vardas, String veisle, String lytis, double svoris, int amzius) {
        this.vardas = vardas;
        this.veisle = veisle;
        this.lytis = lytis;
        this.svoris = svoris;
        this.amzius = amzius;
    }

    public Kate(){ }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getVeisle() {
        return veisle;
    }

    public void setVeisle(String veisle) {
        this.veisle = veisle;
    }

    public String getLytis() {
        return lytis;
    }

    public void setLytis(String lytis) {
        this.lytis = lytis;
    }

    public double getSvoris() {
        return svoris;
    }

    public void setSvoris(double svoris) {
        this.svoris = svoris;
    }

    public int getAmzius() {
        return amzius;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    @Override
    public String toString() {
        return String.format("Kates vardas: %s, veisle: %s, lytis: %s, svoris: %.2f kg, amzius: %d",
                vardas, veisle, lytis, svoris, amzius);
    }
}
