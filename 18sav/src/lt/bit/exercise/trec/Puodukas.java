package lt.bit.exercise.trec;

public class Puodukas extends Object {
    char spalva;
    int turis;
    protected int kiekis;

    public Puodukas(char sp, int turis) {
        if (sp == 'j' || sp == 'J') {
            sp = 'b';
        }
        spalva = sp;
        this.turis = turis;
        kiekis = 0;

    }

    public void ipilk(int kiek) {
        if (kiek > 0)
            this.kiekis += kiek;
        if (this.kiekis > this.turis) {
            this.kiekis = this.turis;
        }
    }

    public void isgerk(int kiek) {
        if (kiek > 0) {
            this.kiekis -= kiek;
            if (this.kiekis < 0) {
                this.kiekis = 0;
            }
        }

    }

    public int getKiekis() {
        return this.kiekis;
    }

    public char getSpalva() {
        return this.spalva;
    }

    public void setSpalva(char spalva) {
        if (spalva!='J'&&spalva!='j'){
            this.spalva = spalva;
        }
    }
}
