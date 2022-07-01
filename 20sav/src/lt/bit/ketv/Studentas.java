package lt.bit.ketv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Studentas {
    String vardas;
    String pavarde;
    private List<Integer> pazymiai;

    public Studentas(String vardas, String pavarde, List<Integer> pazymiai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pazymiai = pazymiai;
    }
    public Studentas(String vardas, String pavarde, int ...pazymiai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pazymiai = new ArrayList<>();
        for (int p : pazymiai){
            this.pazymiai.add(p);
        }
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

    public List<Integer> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(List<Integer> pazymiai) {
        this.pazymiai = pazymiai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studentas)) return false;
        Studentas studentas = (Studentas) o;
        return Objects.equals(getVardas(), studentas.getVardas()) && Objects.equals(getPavarde(), studentas.getPavarde()) && Objects.equals(getPazymiai(), studentas.getPazymiai());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVardas(), getPavarde(), getPazymiai());
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", pazymiai=" + pazymiai +
                '}';
    }
}
