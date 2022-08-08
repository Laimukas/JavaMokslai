package lt.bit.jpatest;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "zmones")
public class Zmogus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //kadangi mes MySQL Id yra Autoincrement tai naudojam sita "IDENTITY"
    private Integer id;
    private String vardas;
    private String pavarde;
    @Column(name = "gimimo_data")
    @Temporal(TemporalType.DATE)
    private Date gimimoData;
    private BigDecimal alga;

    public Zmogus() {
    }

    public Zmogus(Integer id, String vardas, String pavarde, Date gimimoData, BigDecimal alga) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoData = gimimoData;
        this.alga = alga;
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
        return    "Zmogus id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + ", gimimoData=" + gimimoData + ", alga=" + alga ;

//                String.format("Zmogus: id: %d ,vardas: %s ,pavarde: %s ,gimimo data: %s ,alga: %a",id,vardas,pavarde,gimimoData,alga);


    }

}
