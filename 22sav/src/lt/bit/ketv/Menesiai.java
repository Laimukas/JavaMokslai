package lt.bit.ketv;

public enum Menesiai {
    SAUSIS(MetuLaikai.ZIEMA, 31),
    VASARIS(MetuLaikai.ZIEMA, 28),
    KOVAS(MetuLaikai.PAVASARIS, 31),
    BALANDIS(MetuLaikai.PAVASARIS, 30),
    GEGUZE(MetuLaikai.PAVASARIS, 31),
    BIRZELIS(MetuLaikai.VASARA, 30),
    LIEPA(MetuLaikai.VASARA, 31),
    RUGPJUTIS(MetuLaikai.VASARA, 31),
    RUGPSEJIS(MetuLaikai.RUDUO, 30),
    SPALIS(MetuLaikai.RUDUO, 31),
    LAPKRITIS(MetuLaikai.RUDUO, 30),
    GRUODIS(MetuLaikai.ZIEMA, 31);


    private final MetuLaikai metuLaikas;
    private final int dienos;

    Menesiai(MetuLaikai ml, int dienos) {
        this.metuLaikas = ml;
        this.dienos = dienos;
    }

    public MetuLaikai getMetuLaikas() {
        return metuLaikas;
    }

    public int getDienos() {
        return dienos;
    }

}
