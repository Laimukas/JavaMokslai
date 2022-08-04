package zmoneswebdb;

public class Kontaktas {

    private int id;
    private String tipas;
    private String reiksme;

    public Kontaktas() {
    }
    public Kontaktas(String tipas, String reiksme) {
        this.id = id;
        this.tipas = tipas;
        this.reiksme = reiksme;
    }

    public Kontaktas(int id,String tipas, String reiksme) {
        this.id = id;
        this.tipas = tipas;
        this.reiksme = reiksme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    public String getReiksme() {
        return reiksme;
    }

    public void setReiksme(String reiksme) {
        this.reiksme = reiksme;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        final Kontaktas other = (Kontaktas) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Kontaktas{" + "id=" + id + ", tipas=" + tipas + ", reiksme=" + reiksme + '}';
    }

}
