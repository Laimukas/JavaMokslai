package lt.bit.antr.uzduotis2.DestytojoAliaus;


public class Zmogus implements Comparable<Zmogus> {

    private static int nextId = 1;

    private int id;
    private String vardas;
    private String pavarde;

    public Zmogus(int id, String vardas, String pavarde) {
        this.id = id;
        if (this.id >= nextId) {
            nextId = this.id + 1;
        }
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public Zmogus(String vardas, String pavarde) {
        this.id = nextId++;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zmogus other = (Zmogus) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Zmogus{" + "id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + '}';
    }


    @Override
    public int compareTo(Zmogus o) {
        if ((this.vardas == null && o.vardas == null) || this.vardas.equalsIgnoreCase(o.vardas)) {
            return (this.pavarde == null) ? -1 : this.pavarde.compareToIgnoreCase(o.pavarde);
        }
        return (this.vardas == null) ? -1 : this.vardas.compareToIgnoreCase(o.vardas);
    }

}
