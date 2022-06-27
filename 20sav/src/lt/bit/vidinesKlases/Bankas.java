package lt.bit.vidinesKlases;

public class Bankas {

    public String pavadinimas;

    private MyList saskaitos;

    private int nextAccountNo;

    public Bankas(String pav) {
        this.pavadinimas = pav;
        this.saskaitos = new MyList();
        this.nextAccountNo = 1;
    }
    public String toString() {
        String ret = this.pavadinimas + "\r\n";
        double balansas = 0;
        for (int i = 0; i < this.saskaitos.size(); i++) {
            Saskaita s = (Saskaita) this.saskaitos.get(i);
            balansas += s.amount;
            ret += "\t" + s + "\r\n";
        }
        ret += "Bendras balansas: " + balansas;
        return ret;
    }
    public class Saskaita {

        public String vardas;
        public String pavarde;
        public int accountNo;
        public double amount;

        public Saskaita(String vardas, String pavarde) {
            this.vardas = vardas;
            this.pavarde = pavarde;
            this.accountNo = nextAccountNo++;
            this.amount = 0;
            saskaitos.add(this);
        }
        public void inesti(double kiek) {
            this.amount += kiek;
        }
        public void isimti(int kiek) {
            this.amount -= kiek;
        }
        public String toString() {
            return this.vardas + " " + this.pavarde + " " + pavadinimas + "(" + this.accountNo + "):" + this.amount;
        }
    }
}