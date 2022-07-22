package lt.bit.zmones;

import java.util.Objects;

public class Adresas {

    private static int nextId = 1;

    private int id;
    private String adresas;
    private String miestas;
    private String pastoKodas;
    private String valstybe;

    public Adresas() {
        this(null, null,null,null);
    }

    public Adresas(String adresas, String miestas, String pastoKodas, String valstybe) {
        this.id = nextId++;
        this.adresas = adresas;
        this.miestas = miestas;
        this.pastoKodas = pastoKodas;
        this.valstybe = valstybe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getPastoKodas() {
        return pastoKodas;
    }

    public void setPastoKodas(String pastoKodas) {
        this.pastoKodas = pastoKodas;
    }

    public String getValstybe() {
        return valstybe;
    }

    public void setValstybe(String valstybe) {
        this.valstybe = valstybe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresas)) return false;
        Adresas adresas1 = (Adresas) o;
        return getId() == adresas1.getId() && Objects.equals(getAdresas(), adresas1.getAdresas()) && Objects.equals(getMiestas(), adresas1.getMiestas()) && Objects.equals(getPastoKodas(), adresas1.getPastoKodas()) && Objects.equals(getValstybe(), adresas1.getValstybe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdresas(), getMiestas(), getPastoKodas(), getValstybe());
    }

    @Override
    public String toString() {
        return "Adresas{" +
                "id=" + id +
                ", adresas='" + adresas + '\'' +
                ", miestas='" + miestas + '\'' +
                ", pastoKodas='" + pastoKodas + '\'' +
                ", valstybe='" + valstybe + '\'' +
                '}';
    }
}
