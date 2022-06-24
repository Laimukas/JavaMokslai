package lt.bit;

public class Sunkvezimis extends Transportas{
    int asys;
    String marke;
    String spalva;
    String paskirtis;
    private int kelias;
    private int greitis;
    private int maxGreitis;

    public Sunkvezimis(int ratai, boolean variklis,int asys,String marke,String spalva,String paskirtis) {
        super(ratai, variklis);
        this.asys = asys;
        this.marke = marke;
        this.spalva = spalva;
        this.paskirtis = paskirtis;
        this.maxGreitis = 90;
        this.kelias = 0;
        this.greitis = 0;
    }

    public int getAsys() {
        return asys;
    }

    public void setAsys(int asys) {
        this.asys = asys;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getSpalva() {
        return spalva;
    }

    public void setSpalva(String spalva) {
        this.spalva = spalva;
    }

    public String getPaskirtis() {
        return paskirtis;
    }

    public void setPaskirtis(String paskirtis) {
        this.paskirtis = paskirtis;
    }
    public int getKelias() {
        return kelias;
    }

    public void setKelias(int kelias) {
        this.kelias = kelias;
    }

    public int getGreitis() {
        return greitis;
    }

    public void setGreitis(int greitis) {
        this.greitis = greitis;
    }

    public int getMaxGreitis() {
        return maxGreitis;
    }

    public void setMaxGreitis(int maxGreitis) {
        this.maxGreitis = maxGreitis;
    }

    public void gazas(int kiek) {
        if (kiek > 0) {
            this.greitis += kiek;
            if (this.greitis < 0) {
                this.greitis = 0;
            }
        }
    }

    public void stabdis(int kiek) {
        if (kiek > 0) {
            this.greitis -= kiek;
            if (this.greitis < 0) {
                this.greitis = 0;
            }
        }
    }

    public void vaziuojam() {
        this.kelias += this.greitis;
    }

    @Override
    public String toString() {
        return String.format("Sunkvezimis: %s, paskirtis: %s, spalva: %s, asys: %d, ratai: %d, yra variklis: %s, kelias: %d, greitis: %d, maxGreitis: %d", marke,paskirtis,spalva,asys,ratai,variklis, kelias, greitis, maxGreitis);


    }
}
