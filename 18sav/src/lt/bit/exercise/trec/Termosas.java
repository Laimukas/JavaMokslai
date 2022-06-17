package lt.bit.exercise.trec;

public class Termosas extends Puodukas {

    private int temp;

    public Termosas(char spalva, int turis) {
        super(spalva, turis);
        this.temp = 20;
    }

    public int getTemp() {
        return temp;
    }

    public void ipilk(int kiek) {
        if (kiek > 0)
            this.kiekis += kiek;
        if (this.kiekis > this.turis) {
            this.kiekis = this.turis;
        }
        this.temp -= 3;
    }

    public void pasildyk(int kiek) {
        this.temp += kiek;
    }

    public void atvesink(int kiek) {
        this.temp -= kiek;
    }

    @Override
    public String toString() {
        return "Termosas{" +
                "spalva=" + spalva +
                ", turis=" + turis +
                ", kiekis=" + kiekis +
                ", temp=" + temp +
                '}';
    }

    public boolean equals(Object obj) {
        /*
        obj: -> t2
        this: -> t1
         */

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Termosas)) {
            return false;
        }
        Termosas t = (Termosas) obj;
//        if (this.getSpalva() == t.getSpalva() &&
//                this.turis == t.turis &&
//                this.kiekis == t.kiekis &&
//                this.temp == t.temp) {
//            return true;
//        } else {
//            return false;
//        }
        //arba
        return
                this.getSpalva() == t.getSpalva() &&
                        this.turis == t.turis &&
                        this.kiekis == t.kiekis &&
                        this.temp == t.temp;
    }
}
