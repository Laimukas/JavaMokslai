package exercises.sportininkai;

public class Sportininkas {

    private String vardas;
    private String pavarde;
    private String komandosPavadinimas ;
    private int ugis;
    private double svoris;

    public Sportininkas(String vardas, String pavarde, String komandosPavadinimas, int ugis, double svoris) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.komandosPavadinimas = komandosPavadinimas;
        this.ugis = ugis;
        this.svoris = svoris;
    }
    public Sportininkas (){}

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getKomandosPavadinimas() {
        return komandosPavadinimas;
    }

    public void setKomandosPavadinimas(String komandosPavadinimas) {
        this.komandosPavadinimas = komandosPavadinimas;
    }

    public int getUgis() {
        return ugis;
    }

    public void setUgis(int ugis) {
        this.ugis = ugis;
    }

    public double getSvoris() {
        return svoris;
    }

    public void setSvoris(double svoris) {
        this.svoris = svoris;
    }

    @Override
    public String toString() {
        return String.format("Sportininko vardas: %-8s, pavarde: %-10s, komandos pavadinimas: %-15s, " +
                "ugis: %d cm, svoris: %.2f kg",vardas,pavarde,komandosPavadinimas,ugis,svoris);

    }
}
