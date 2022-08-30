package lt.bit.spring_web.data;

import java.util.Objects;

public class Preke {
    
    private static int nextId = 1;
    
    private Integer id;
    private String pavadinimas;
    private Float kiekis;

    public Preke() {
        this.id = nextId++;
    }
    
    public Preke(String pavadinimas, Float kiekis) {
        this.id = nextId++;
        this.pavadinimas = pavadinimas;
        this.kiekis = kiekis;
    }

    public Preke(Integer id, String pavadinimas, Float kiekis) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kiekis = kiekis;
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
    
    public Float getKiekis() {
        return kiekis;
    }

    public void setKiekis(Float kiekis) {
        this.kiekis = kiekis;
    }
    
    public void  assignId() {
        this.id = nextId++;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Preke other = (Preke) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Preke{" + "id=" + id + ", pavadinimas=" + pavadinimas + ", kiekis=" + kiekis + '}';
    }

}
