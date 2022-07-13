package lt.bit.trec;

public enum Menesiai {
    SAUSIS(31,"ZIEMA"),
    VASARIS(28,"ZIEMA"),
    KOVAS(31,"PAVASARIS"),
    BALANDIS(30,"PAVASARIS"),
    GEGUZIS(31,"PAVASARIS"),
    BIRZELIS(30,"VASARA"),
    LIEPA(31,"VASARA"),
    RUGPJUTIS(31,"VASARA"),
    RUGSEJIS(30,"RUDUO"),
    SPALIS(31,"RUDUO"),
    LAPKRITIS(30,"RUDUO"),
    GRUODIS(31,"ZIEMA");

    private int menesioDienos;
    private String metuLaikai;

    private Menesiai(int menesioDienos,String metuLaikai) {
        this.menesioDienos = menesioDienos;
        this.metuLaikai = metuLaikai;
    }

    public int getMenesioDienos() {
        return menesioDienos;
    }

    public String getMetuLaikai() {
        return metuLaikai;
    }

    static Menesiai menesis(int d) {
        return values()[d-1];
    }

}
