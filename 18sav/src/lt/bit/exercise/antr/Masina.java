package lt.bit.exercise.antr;

public class Masina {

    private String pavadinimas;
    private int kelias;
    private int greitis;
    private int maxGreitis;

    public Masina(String pavadinimas, int maxGreitis) {
        this.pavadinimas = pavadinimas;
        this.maxGreitis = maxGreitis;
        this.kelias = 0;
        this.greitis = 0;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
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
        return String.format("Masina: %s, kelias: %d, greitis: %d, maxGreitis: %d", pavadinimas, kelias, greitis, maxGreitis);

    }
}
