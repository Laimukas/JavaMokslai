package lt.bit.jpatest;

import jakarta.persistence.*;

@Entity
@Table(name = "kontaktai")
public class Kontaktas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "zmogus_id")
//    private Integer zmogusId;
    private String tipas;
    private String reiksme;
    @ManyToOne
    @JoinColumn(name = "zmogus_id")
    private Zmogus zmogus;

    public Kontaktas() {
    }
    public Kontaktas(Integer id, String tipas, String reiksme) {
        this.id = id;
        this.tipas = tipas;
        this.reiksme = reiksme;

    }


    public Kontaktas(Integer id, String tipas, String reiksme, Zmogus zmogus) {
        this.id = id;
        this.tipas = tipas;
        this.reiksme = reiksme;
        this.zmogus = zmogus;
    }
    //    public Kontaktas(Integer id, Integer zmogusId, String tipas, String reiksme) {
//        this.id = id;
//        this.zmogusId = zmogusId;
//        this.tipas = tipas;
//        this.reiksme = reiksme;
//    }

    public Zmogus getZmogus() {
        return zmogus;
    }

    public void setZmogus(Zmogus zmogus) {
        this.zmogus = zmogus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getZmogusId() {
//        return zmogusId;
//    }
//
//    public void setZmogusId(Integer zmogusId) {
//        this.zmogusId = zmogusId;
//    }

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
        return "Kontaktas{" +
                "id=" + id +
                ", tipas='" + tipas + '\'' +
                ", reiksme='" + reiksme + '\'' +
                ", zmogus=" + zmogus +
                '}';
    }
    //    @Override
//    public String toString() {
//        return "Kontaktas{" + "id=" + id + ", zmogusId=" + zmogusId + ", tipas=" + tipas + ", reiksme=" + reiksme + '}';
//    }

}