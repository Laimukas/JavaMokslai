package lt.bit.ketv;

import java.util.Objects;

public class Zmogus {

    private String vardas, pavarde;
    private int gimimoMetai;

    public Zmogus(String vardas, String pavarde,Integer gimimoMetai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoMetai = 2000;
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

    public int getGimimoMetai() {
        return gimimoMetai;
    }

    public void setGimimoMetai(int gimimoMetai) {
        this.gimimoMetai = gimimoMetai;
    }

    @Override
    public String toString() {
//        Date d = new Date();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException ex) {
//            // ignore
//        }
        return "Zmogus{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVardas(), getPavarde(), getGimimoMetai());
    }

    @Override

    //sugeneruoti kompo

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zmogus)) return false;
        Zmogus zmogus = (Zmogus) o;
        return getGimimoMetai() == zmogus.getGimimoMetai() && Objects.equals(getVardas(), zmogus.getVardas()) && Objects.equals(getPavarde(), zmogus.getPavarde());
    }

    //sugeneruotas musu

    //    public boolean equals(Object o) {
//        if (o instanceof Zmogus) {
//            Zmogus z = (Zmogus) o;
//
//            return this.vardas.equals(z.vardas) && this.pavarde.equals(z.pavarde) && this.gimimoMetai==z.gimimoMetai;
//        }
//        return false;
//    }
    /*
    jei dvieju objektu hashCode yra vienodi, tai equals gali buti ir true ir false
    jei dvieju objektu hashCode yra skirtingi, tai equals turi buti false
    jei equals yra true, tai dvieju objektu hashCode turi buti toks pats
    jei equals yra false, tai dvieju objektu hashCode gali buti ir tokie patys ir skirtingi
     */
}
