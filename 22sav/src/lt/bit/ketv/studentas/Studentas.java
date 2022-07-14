package lt.bit.ketv.studentas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Sitos klases atstovai saugo studenta (vardas ir pavarde) su jo pazymiais.
 */
public class Studentas {
    private String vardas;
    private String pavarde;
    private List<Integer> pazymiai;
    /**
     * Sukuria nauja studenta su nurodytais vardu ir pavarde.
     * Naujai sukurtas studentas pazymiu neturi.
     *
     * @param vardas - studento vardas
     * @param pavarde - studento pavarde
     */
    public Studentas (String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pazymiai = new ArrayList();
    }
    public Studentas (String vardas, String pavarde, int ...pazymiai)
            throws BlogasPazymysException {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pazymiai = new ArrayList();
        for (int p : pazymiai) {
            if (p > 0 && p < 11) {
                this.pazymiai.add(p);
            } else {
                throw new BlogasPazymysException("Neteisingas pazymys: " + p);
            }
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
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.vardas);
        hash = 97 * hash + Objects.hashCode(this.pavarde);
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
        final Studentas other = (Studentas) obj;
        if (!Objects.equals(this.vardas, other.vardas)) {
            return false;
        }
        return Objects.equals(this.pavarde, other.pavarde);
    }
    @Override
    public String toString() {
        return "Studentas{" + "vardas=" + vardas + ", pavarde=" + pavarde + ", pazymiai=" + pazymiai + '}';
    }
    public void naujasPazymys(int p)
            throws BlogasPazymysException {
        if (p > 0 && p < 11) {
            this.pazymiai.add(p);
        } else {
            throw new BlogasPazymysException("Neteisingas pazymys: " + p);
        }
    }
    public float getVidurkis() throws NeraPazymiuException {
        if (this.pazymiai.isEmpty()) {
            throw new NeraPazymiuException("Studentas neturi pazymiu");
        }
        int suma = 0;
        for (Integer p : this.pazymiai) {
            suma += p;
        }
        return (float) suma / this.pazymiai.size();
    }
}


