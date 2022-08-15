package lt.bit.pirkiniai_webjpa.data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cekiai")
public class Cekis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date data;
    private String parduotuve;
    private String aprasymas;
    @OneToMany(mappedBy = "cekis")
    private List<Preke> prekes;

    public Cekis() {
    }

    public Cekis(Integer id, Date data, String parduotuve, String aprasymas) {
        this.id = id;
        this.data = data;
        this.parduotuve = parduotuve;
        this.aprasymas = aprasymas;
        this.prekes = new ArrayList();
    }

    public Cekis(Integer id, Date data, String parduotuve) {
        this.id = id;
        this.data = data;
        this.parduotuve = parduotuve;
        this.aprasymas = aprasymas;
        this.prekes = new ArrayList<>();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getParduotuve() {
        return parduotuve;
    }

    public void setParduotuve(String parduotuve) {
        this.parduotuve = parduotuve;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public BigDecimal getSuma() {
        BigDecimal suma = new BigDecimal(0);
        for (Preke preke : prekes) {
            suma = suma.add(preke.getKaina().multiply(preke.getKiekis()));
        }
        return suma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cekis)) return false;
        Cekis cekis = (Cekis) o;
        return Objects.equals(getId(), cekis.getId()) && Objects.equals(getData(), cekis.getData()) && Objects.equals(getParduotuve(), cekis.getParduotuve()) && Objects.equals(getAprasymas(), cekis.getAprasymas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getParduotuve(), getAprasymas());
    }

    @Override
    public String toString() {
        return "Cekis: " +
                "id=" + id +
                ", data=" + data +
                ", parduotuve='" + parduotuve + '\'' +
                ", aprasymas='" + aprasymas +
                ", suma=" + getSuma() +
                ";"
                ;
    }
}
