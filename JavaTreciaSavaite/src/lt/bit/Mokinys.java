package lt.bit;

import java.util.Arrays;

public class Mokinys {

    private String vardas;
    private String pavarde;
    private String klase;
    private int[] pazymiai;

    //konstruktorius
    public Mokinys(String vardas, String pavarde, String klase, int[] pazymiai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.klase = klase;
        this.pazymiai = pazymiai;
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

    public String getKlase() {
        return klase;
    }

    public void setKlase(String klase) {
        this.klase = klase;
    }

    public int[] getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(int[] pazymiai) {
        this.pazymiai = pazymiai;
    }

    //cia dar namu darbuose uzduotis buvo,tai papildem si sarasa
    @Override
    public String toString() {
        return "Mokinys{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", klase='" + klase + '\'' +
                ", pazymiai=" + Arrays.toString(pazymiai) +
                ", vidurkis=" + pazymiuVidurkis() + '\'' +
                '}';
    }

    // uzduoties dalis 2 - apskaiciuoti pazymiu vidurki
    public double pazymiuVidurkis() {
        double suma = 0;
        for (int i = 0; i < pazymiai.length; i++) {
            suma = suma + pazymiai[i];
        }
        return suma / pazymiai.length;
    }

    // uzduoties dalis 3 - Rasti geriausiai besimokanti mokini
    public static Mokinys gautiGeriausiaiBesimokanti(Mokinys[] m) {
        Mokinys geriausias = null;
        if (m.length > 0) {
            geriausias = m[0];
        } else {
            return null;
        }

        for (int i = 1; i < m.length; i++) {
            if (geriausias.pazymiuVidurkis() < m[i].pazymiuVidurkis()) {
                geriausias = m[i];
            }
        }
        return geriausias;
    }

    // uzduoties dalis 4 - Atspausdinti klasiu sarasa(masyva)


}
