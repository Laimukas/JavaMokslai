package lt.bit.spring;

import java.util.Objects;

public class Atkarpa {

    private Taskas nuo;
    private Taskas iki;
    
    public Atkarpa(float nuoX, float nuoY, float ikiX, float ikiY) {
        this(new Taskas(nuoX, nuoY), new Taskas(ikiX, ikiY));
    }
    
    public Atkarpa(Taskas nuo, Taskas iki) {
        this.nuo = nuo;
        this.iki = iki;
    }

    public Taskas getNuo() {
        return nuo;
    }

    public void setNuo(Taskas nuo) {
        this.nuo = nuo;
    }

    public Taskas getIki() {
        return iki;
    }

    public void setIki(Taskas iki) {
        this.iki = iki;
    }

    public float ilgis() {
        if (nuo == null || iki == null) {
            return -1;
        }
        float x = Math.abs(nuo.getX() - iki.getX());
        float y = Math.abs(nuo.getY() - iki.getY());
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nuo);
        hash = 29 * hash + Objects.hashCode(this.iki);
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
        final Atkarpa other = (Atkarpa) obj;
        if (!Objects.equals(this.nuo, other.nuo)) {
            return false;
        }
        return Objects.equals(this.iki, other.iki);
    }

    @Override
    public String toString() {
        return "Atkarpa{" + "nuo=" + nuo + ", iki=" + iki + '}';
    }
    
    
}
