package lt.bit.pirkiniai_webjpa.data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tipai")
public class Tipas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pavadinimas;
    @OneToMany(mappedBy = "tipas")
    private List<Preke> prekes;

    public Tipas() {
    }

    public Tipas(Integer id, String pavadinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.prekes = null;
//        this.prekes = new ArrayList();
    }

    public List<Preke> getPrekes() {
        return prekes;
    }

    public void setPrekes(List<Preke> prekes) {
        this.prekes = prekes;
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
        return Objects.equals(getId(), tipas.getId()) && Objects.equals(getPavadinimas(), tipas.getPavadinimas()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPavadinimas());
    }

    @Override
    public String toString() {
        return "Tipas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
//                ", prekes=" + prekes +
                '}';
    }
}
