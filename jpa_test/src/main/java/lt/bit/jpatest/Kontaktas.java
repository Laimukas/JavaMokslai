package lt.bit.jpatest;

public class Kontaktas {

    private Integer id;
    private Integer zmogusId;
    private String tipas;
    private String reiksme;

    public Kontaktas() {
    }

    public Kontaktas(Integer id, Integer zmogusId, String tipas, String reiksme) {
        this.id = id;
        this.zmogusId = zmogusId;
        this.tipas = tipas;
        this.reiksme = reiksme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZmogusId() {
        return zmogusId;
    }

    public void setZmogusId(Integer zmogusId) {
        this.zmogusId = zmogusId;
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
        return "Kontaktas{" + "id=" + id + ", zmogusId=" + zmogusId + ", tipas=" + tipas + ", reiksme=" + reiksme + '}';
    }

}