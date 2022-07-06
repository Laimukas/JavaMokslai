package lt.bit.antr.uzduotis2;

import java.util.List;
import java.util.Objects;

//Simono metodas, reik turet omeni jog Zmogus2 klase,atitinkamai perduodant info Main2 klasei

public class Zmogusss {
    private String vardas;
    private String pavarde;
    private Long id;
    public Zmogusss(String vardas, String pavarde, Long id) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.id = id;
    }
    public String getVardas() {
        return vardas;
    }
    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
    public String getPavarde() {
        return pavarde;
    }
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zmogusss zmogus2 = (Zmogusss) o;
        return Objects.equals(vardas, zmogus2.vardas)
                && Objects.equals(pavarde, zmogus2.pavarde)
                && Objects.equals(id, zmogus2.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(vardas, pavarde, id);
    }
    @Override
    public String toString() {
        return vardas + " " + pavarde + " " + id;
    }
    public int compareTo(Zmogusss z) {
        if(z != null){
            if(this.compareByName(z) == 0){
                return this.compareByLastName(z);
            }
            return this.compareByName(z);
        }
        return 0;
    }
    private int compareByName(Zmogusss z) {
        if(z != null){
            return this.vardas.compareTo(z.vardas);
        }
        return 0;
    }
    private int compareByLastName(Zmogusss z) {
        if(z != null){
            return this.pavarde.compareTo(z.pavarde);
        }
        return 0;
    }
    public Long generateUniqueId(List<Zmogusss> zmones){
        Long maxValue = Long.MIN_VALUE;
        for(Zmogusss z : zmones){
            if(z.getId().compareTo(maxValue) > 0){
                maxValue = z.getId();
            }
        }
        return maxValue + 1;
    }
}
