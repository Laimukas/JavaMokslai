package lt.bit.zmones_webjpa.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gimimoData;
    private BigDecimal alga;
    @OneToMany(mappedBy = "zmogus")
    @JsonIgnore
    private List<Kontaktas> kontaktai;
    @OneToMany(mappedBy = "zmogus")
    @JsonIgnore
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
