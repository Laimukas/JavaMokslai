package lt.bit.inheritance;

public class PasaulioGyv {
    private String vardas;
    String pavarde;
    int gimimoMetai;
    double svoris;
    int ugis;
    Rase rase;
    Statusas statusas;
    Zemynas zemynas;

    public PasaulioGyv(String vardas, String pavarde, int gimimoMetai, double svoris, int ugis,
                       Rase rase, Statusas statusas, Zemynas zemynas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoMetai = gimimoMetai;
        this.svoris = svoris;
        this.ugis = ugis;
        this.rase = rase;
        this.statusas = statusas;
        this.zemynas=zemynas;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public int getGimimoMetai() {
        return gimimoMetai;
    }

    public double getSvoris() {
        return svoris;
    }

    public int getUgis() {
        return ugis;
    }
    public Rase getRase() {
        return rase;
    }
    public Statusas getStatusas() {
        return statusas;
    }
    public Zemynas getZemynas() {
        return zemynas;
    }

    @Override
    public String toString() {
        return "Pasaulio Gyventojas: " +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", gimimoMetai=" + gimimoMetai +
                ", svoris=" + svoris +
                ", ugis=" + ugis +
                ", rase=" + rase +
                ", statusas=" + statusas +
                ", zemynas=" + zemynas;
    }
}
