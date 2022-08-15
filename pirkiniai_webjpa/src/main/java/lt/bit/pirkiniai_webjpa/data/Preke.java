package lt.bit.pirkiniai_webjpa.data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "prekes")
public class Preke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String preke;
    private BigDecimal kiekis;
    private BigDecimal kaina;

    @ManyToOne
    @JoinColumn(name = "cekis_id")
    private Cekis cekis;
    @ManyToOne
    @JoinColumn(name = "tipas_id")
    private Tipas tipas;


    public Preke() {
    }

    public Preke(Integer id, String preke, BigDecimal kiekis, BigDecimal kaina) {
        this.id = id;
        this.preke = preke;
        this.kiekis = kiekis;
        this.kaina = kaina;
        this.cekis = null;
        this.tipas = null;
    }

    public Preke(String preke, BigDecimal kiekis, BigDecimal kaina) {

        this.preke = preke;
        this.kiekis = kiekis;
        this.kaina = kaina;
    }

    public Cekis getCekis() {
        return cekis;
    }

    public void setCekis(Cekis cekis) {
        this.cekis = cekis;
    }

    public Tipas getTipas() {
        return tipas;
    }

    public void setTipas(Tipas tipas) {
        this.tipas = tipas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreke() {
        return preke;
    }

    public void setPreke(String preke) {
        this.preke = preke;
    }

    public BigDecimal getKiekis() {
        return kiekis;
    }

    public void setKiekis(BigDecimal kiekis) {
        this.kiekis = kiekis;
    }

    public BigDecimal getKaina() {
        return kaina;
    }

    public void setKaina(BigDecimal kaina) {
        this.kaina = kaina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preke)) return false;
        Preke preke1 = (Preke) o;
        return Objects.equals(getId(), preke1.getId()) && Objects.equals(getPreke(), preke1.getPreke()) && Objects.equals(getKiekis(), preke1.getKiekis()) && Objects.equals(getKaina(), preke1.getKaina()) && Objects.equals(getCekis(), preke1.getCekis()) && Objects.equals(getTipas(), preke1.getTipas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPreke(), getKiekis(), getKaina(), getCekis(), getTipas());
    }

    @Override
    public String toString() {
        return "Preke{" +
                "id=" + id +
                ", preke='" + preke + '\'' +
                ", kiekis=" + kiekis +
                ", kaina=" + kaina +
//                ", cekis=" + cekis +
//                ", tipas=" + tipas +
                '}';
    }
}

