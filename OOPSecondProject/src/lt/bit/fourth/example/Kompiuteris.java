package lt.bit.fourth.example;

public class Kompiuteris {
    private String prekesKodas;
    private String gamintojas;
    private int kaina;
    private int svoris;
    private int garantija;

    public Kompiuteris(String prekesKodas, String gamintojas, int kaina, int svoris, int garantija) {
        this.prekesKodas = prekesKodas;
        this.gamintojas = gamintojas;
        this.kaina = kaina;
        this.svoris = svoris;
        this.garantija = garantija;
    }

    public String getPrekesKodas() {
        return prekesKodas;
    }

    public String getGamintojas() {
        return gamintojas;
    }

    public int getKaina() {
        return kaina;
    }

    public int getSvoris() {
        return svoris;
    }

    public int getGarantija() {
        return garantija;
    }

    @Override
    public String toString() {
        return  "prekesKodas=" + prekesKodas +
                ", gamintojas='" + gamintojas + '\'' +
                ", kaina=" + kaina +
                ", svoris=" + svoris +
                ", garantija=" + garantija;
    }
}
