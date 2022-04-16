package lt.bit.third.example;

public class Knyga {
    private String autorius;
    private String pavadinimas;
    private int leidimoMetai;
    private String knygosKodas;
    private String leidykla;
    private int puslapiuSkaicius;

    public Knyga(String autorius, String pavadinimas, int leidimoMetai, String knygosKodas, String leidykla, int puslapiuSkaicius) {
        this.autorius = autorius;
        this.pavadinimas = pavadinimas;
        this.leidimoMetai = leidimoMetai;
        this.knygosKodas = knygosKodas;
        this.leidykla = leidykla;
        this.puslapiuSkaicius = puslapiuSkaicius;
    }

    public String getAutorius() {
        return autorius;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public int getLeidimoMetai() {
        return leidimoMetai;
    }

    public String getKnygosKodas() {
        return knygosKodas;
    }

    public String getLeidykla() {
        return leidykla;
    }

    public int getPuslapiuSkaicius() {
        return puslapiuSkaicius;
    }

    @Override
    public String toString() {
        return  "autorius='" + autorius + '\'' +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", leidimoMetai=" + leidimoMetai +
                ", knygosKodas='" + knygosKodas + '\'' +
                ", leidykla='" + leidykla + '\'' +
                ", puslapiuSkaicius=" + puslapiuSkaicius ;
    }
}
