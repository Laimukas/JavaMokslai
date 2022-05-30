package exercises.studentai;

public class Studentas {

    private String vardas;
    private String pavarde;
    private String grupe ;
    private double vidurkis;

    public Studentas(String vardas, String pavarde, String grupe, double vidurkis) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.grupe = grupe;
        this.vidurkis = vidurkis;
    }
    public Studentas (){}

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

    public String getGrupe() {
        return grupe;
    }

    public void setGrupe(String grupe) {
        this.grupe = grupe;
    }

    public double getVidurkis() {
        return vidurkis;
    }

    public void setVidurkis(double vidurkis) {
        this.vidurkis = vidurkis;
    }

    @Override
    public String toString() {
        return String.format("Studento vardas: %-8s, pavarde: %-10s, grupe: %-5s, vidurkis: %.1f",vardas,pavarde,grupe,vidurkis);
    }
}
