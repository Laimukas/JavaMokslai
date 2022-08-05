package zmoneswebdb;

public class Adresas {
    
    private Integer id;
    private Integer zmogusId;
    private String adresas;
    private String miestas;
    private String pastoKodas;

    public Adresas() {
    }

    public Adresas(Integer id, Integer zmogusId, String adresas, String miestas, String pastoKodas) {
        this.id = id;
        this.zmogusId = zmogusId;
        this.adresas = adresas;
        this.miestas = miestas;
        this.pastoKodas = pastoKodas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZmogusId() {
        return zmogusId;
    }

    public void setZmogusId(Integer zmogusId) {
        this.zmogusId = zmogusId;
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
        final Adresas other = (Adresas) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Adresas{" + "id=" + id + ", zmogusId=" + zmogusId + ", adresas=" + adresas + ", miestas=" + miestas + ", pastoKodas=" + pastoKodas + '}';
    }

}
