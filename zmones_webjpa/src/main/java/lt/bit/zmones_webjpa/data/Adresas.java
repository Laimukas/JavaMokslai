package lt.bit.zmones_webjpa.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adresai")
public class Adresas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String adresas;
    private String miestas;
    @Column(name = "pasto_kodas")
    private String pastoKodas;
    @ManyToOne
    @JoinColumn(name = "zmogus_id")
    private Zmogus zmogus;

    public Adresas() {
    }

    public Adresas(Integer id, String adresas, String miestas, String pastoKodas) {
        this.id = id;
        this.adresas = adresas;
        this.miestas = miestas;
        this.pastoKodas = pastoKodas;
        this.zmogus = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getPastoKodas() {
        return pastoKodas;
    }

    public void setPastoKodas(String pastoKodas) {
        this.pastoKodas = pastoKodas;
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
        final Adresas other = (Adresas) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Adresas{" + "id=" + id + ", adresas=" + adresas + ", miestas=" + miestas + ", pastoKodas=" + pastoKodas + ", zmogus=" + zmogus + '}';
    }

}
