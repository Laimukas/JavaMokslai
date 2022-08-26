package lt.bit.spring;

import java.util.Objects;

public class Apskritimas {
    
    private Taskas centras;
    private float spindulys;

    public Apskritimas() {
        this(new Taskas(0, 0));
    }

    public Apskritimas(Taskas centras) {
        this(centras, 1);
    }

    public Apskritimas(Taskas centras, float spindulys) {
        this.centras = centras;
        this.spindulys = spindulys;
    }

    public float getSpindulys() {
        return spindulys;
    }

    public void setSpindulys(float spindulys) {
        this.spindulys = spindulys;
    }

    public Taskas getCentras() {
        return centras;
    }

    public void setCentras(Taskas centras) {
        this.centras = centras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.centras);
        hash = 97 * hash + Float.floatToIntBits(this.spindulys);
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
        final Apskritimas other = (Apskritimas) obj;
        if (Float.floatToIntBits(this.spindulys) != Float.floatToIntBits(other.spindulys)) {
            return false;
        }
        return Objects.equals(this.centras, other.centras);
    }

    @Override
    public String toString() {
        return "Apskritimas{" + "centras=" + centras + ", spindulys=" + spindulys + '}';
    }

}
