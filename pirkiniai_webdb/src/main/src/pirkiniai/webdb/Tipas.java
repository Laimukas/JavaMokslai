package pirkiniai.webdb;

import java.util.Objects;

public class Tipas {

    private Integer id;
    private String pavadinimas;

    public Tipas() {
    }

    public Tipas(Integer id, String pavadinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tipas)) return false;
        Tipas tipas = (Tipas) o;
        return Objects.equals(getId(), tipas.getId()) && Objects.equals(getPavadinimas(), tipas.getPavadinimas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPavadinimas());
    }

    @Override
    public String toString() {
        return "Tipas:" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas +
                ';';
    }
}
