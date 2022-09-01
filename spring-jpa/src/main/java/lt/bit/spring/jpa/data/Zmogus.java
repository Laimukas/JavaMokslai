package lt.bit.spring.jpa.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "zmones")
public class Zmogus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vardas;
    private String pavarde;
    @Column(name = "gimimo_data")
    @Temporal(TemporalType.DATE)
    private Date gimimoData;
    private BigDecimal alga;
    @OneToMany(mappedBy = "zmogus")
    private List<Kontaktas> kontaktai;
    @OneToMany(mappedBy = "zmogus")
    private List<Adresas> adresai;

    public Zmogus() {
    }

    public Zmogus(Integer id, String vardas, String pavarde, Date gimimoData, BigDecimal alga) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoData = gimimoData;
        this.alga = alga;
        this.kontaktai = new ArrayList();
        this.adresai = new ArrayList();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getGimimoData() {
        return gimimoData;
    }

    public void setGimimoData(Date gimimoData) {
        this.gimimoData = gimimoData;
    }

    public BigDecimal getAlga() {
        return alga;
    }

    public void setAlga(BigDecimal alga) {
        this.alga = alga;
    }

    public List<Kontaktas> getKontaktai() {
        return kontaktai;
    }

    public void setKontaktai(List<Kontaktas> kontaktai) {
        this.kontaktai = kontaktai;
    }
    
    public List<Adresas> getAdresai() {
        return adresai;
    }

    public void setAdresai(List<Adresas> adresai) {
        this.adresai = adresai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Zmogus{" + "id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + ", gimimoData=" + gimimoData + ", alga=" + alga + '}';
    }

}
