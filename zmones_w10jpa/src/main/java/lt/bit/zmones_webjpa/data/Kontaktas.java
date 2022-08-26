package lt.bit.zmones_webjpa.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "kontaktai")
public class Kontaktas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipas;
    private String reiksme;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "zmogus_id")
    private Zmogus zmogus;

    public Kontaktas() {
    }

    public Kontaktas(Integer id, String tipas, String reiksme) {
        this.id = id;
        this.tipas = tipas;
        this.reiksme = reiksme;
        this.zmogus = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Zmogus getZmogus() {
        return zmogus;
    }

    public void setZmogus(Zmogus zmogus) {
        this.zmogus = zmogus;
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
