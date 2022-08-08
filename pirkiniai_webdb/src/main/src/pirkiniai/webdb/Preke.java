package pirkiniai.webdb;

import java.math.BigDecimal;
import java.util.Objects;

public class Preke {

    private Integer id;
    private Integer cekisid;
    private String preke;
    private BigDecimal kiekis;
    private BigDecimal kaina;
    private Integer tipasid;

    public Preke() {
    }

    public Preke(Integer id, Integer cekisid, String preke, BigDecimal kiekis, BigDecimal kaina, Integer tipasid) {
        this.id = id;
        this.cekisid = cekisid;
        this.preke = preke;
        this.kiekis = kiekis;
        this.kaina = kaina;
        this.tipasid = tipasid;
    }
    public Preke(String preke, BigDecimal kiekis, BigDecimal kaina) {

        this.preke = preke;
        this.kiekis = kiekis;
        this.kaina = kaina;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCekisid() {
        return cekisid;
    }

    public void setCekisid(Integer cekisid) {
        this.cekisid = cekisid;
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

    public Integer getTipasid() {
        return tipasid;
    }

    public void setTipasid(Integer tipasid) {
        this.tipasid = tipasid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preke)) return false;
        Preke preke1 = (Preke) o;
        return Objects.equals(getId(), preke1.getId()) && Objects.equals(getCekisid(), preke1.getCekisid()) && Objects.equals(getPreke(), preke1.getPreke()) && Objects.equals(getKiekis(), preke1.getKiekis()) && Objects.equals(getKaina(), preke1.getKaina()) && Objects.equals(getTipasid(), preke1.getTipasid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCekisid(), getPreke(), getKiekis(), getKaina(), getTipasid());
    }

    @Override
    public String toString() {
        return "Preke: " +
                "id=" + id +
                ", cekisid=" + cekisid +
                ", preke='" + preke + '\'' +
                ", kiekis=" + kiekis +
                ", kaina=" + kaina +
                ", tipasid=" + tipasid +
                ";";
    }
//    @Override
//    public String toString() {
//        BigDecimal sandauga = kiekis.multiply(kaina);
//        return "Preke: " + preke + ", kainavo" + sandauga + ";";
//    }
}
