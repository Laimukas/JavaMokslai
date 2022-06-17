package lt.bit.exercise.ketv;

public class Studentas {
    private String vardas;
    private String pavarde;
    private int[] pazymiai;

    public Studentas(String vardas, String pavarde, int kiekPazymiu) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pazymiai = new int[kiekPazymiu];
    }
    public String getPilnasVardas() {
        return this.vardas + " " + this.pavarde;
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
    public int[] getPazymiai() {
        return pazymiai;
    }
    public void setPazymiai(int[] pazymiai) {
        this.pazymiai = pazymiai;
    }
    public float getVidurkis() {
        int suma = 0;
        for (int i = 0; i < this.pazymiai.length; i++) {
            suma += this.pazymiai[i];
        }
        return (float) suma / this.pazymiai.length;
    }
    public String toString() {
        String ret = this.vardas + " " + this.pavarde + " (";
        for (int i = 0; i < this.pazymiai.length; i++) {
            ret += this.pazymiai[i];
            if (i < this.pazymiai.length - 1) {
                ret += ", ";
            }
        }
        ret += ")";
        return ret;
    }
}
