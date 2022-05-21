package lt.bit.SkaniausiSaldainiai;

import java.util.List;

public class Gamintojas {
    private String pavadinimas;
    private List<Saldainis>saldainiai;

    public Gamintojas(String pavadinimas, List<Saldainis> saldainiai) {
        this.pavadinimas = pavadinimas;
        this.saldainiai = saldainiai;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Saldainis> getSaldainiai() {
        return saldainiai;
    }

    public void setSaldainiai(List<Saldainis> saldainiai) {
        this.saldainiai = saldainiai;
    }

    @Override
    public String toString() {
        return "Gamintojas{" +
                "pavadinimas='" + pavadinimas + '\'' +
                ", saldainiai=" + saldainiai +
                '}';
    }
}
