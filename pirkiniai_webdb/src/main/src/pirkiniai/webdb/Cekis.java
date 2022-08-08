package pirkiniai.webdb;

import java.util.Date;
import java.util.Objects;

public class Cekis {

    private Integer id;
    private Date data;
    private String parduotuve;
    private String aprasymas;

    public Cekis() {
    }

    public Cekis(Integer id, Date data, String parduotuve, String aprasymas) {
        this.id = id;
        this.data = data;
        this.parduotuve = parduotuve;
        this.aprasymas = aprasymas;
    }
    public Cekis(Integer id, Date data, String parduotuve) {
        this.id = id;
        this.data = data;
        this.parduotuve = parduotuve;
        this.aprasymas = aprasymas;
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
                ", parduotuve='" + parduotuve + '\''+
                ", aprasymas='" + aprasymas + "';"
                ;
    }
}
