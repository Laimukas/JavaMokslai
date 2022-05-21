package lt.bit.SkaniausiSaldainiai;
//Saulius yra saldainių ekspertas. Jis ragauja įvairių gamintojų produkciją
//ir įvertina saldainių skonį 5 balų skalėje (1 – neskanus; 2 – iš bėdos galima valgyti; 3 – galima
//valgyti, bet yra ir skanesnių; 4 – skanus; 5 – labai skanus).
//Parenkite programą, kuri Sauliui pateiktų kiekvieno gamintojo saldainių sąrašą skanumo
//didėjimo tvarka.
//Pradinių duomenų faile Duomenys.txt įrašyta:
//pirmoje eilutėje – saldainių gamintojų skaičius n;
//toliau surašyti duomenys apie kiekvieną gamintoją:
//vienoje eilutėje įrašytas gamintojo pavadinimas (skiriama 25 pozicijos) ir saldainių
//rūšių skaičius r;
//tolesnėse r eilučių įrašytas saldainių rūšies pavadinimas (skiriama po 20 pozicijų) ir
//sveikasis skaičius nuo 1 iki 5, nurodantis saldainio skanumą.
//Rezultatų faile Rezultatai.txt turi būti įrašyta:
//kiekvieno gamintojo pavadinimas;
//to gamintojo saldainiai, išrikiuoti skanumo didėjimo tvarka. Jei yra kelios to paties
//skanumo saldainių rūšys, tai jos gali būti išdėstytos bet kuria tvarka.

public class Saldainis implements Comparable<Saldainis> {

    private String pavadinimas;
    private int ivertinimas;

    public Saldainis(String pavadinimas, int ivertinimas) {
        this.pavadinimas = pavadinimas;
        this.ivertinimas = ivertinimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(int ivertinimas) {
        this.ivertinimas = ivertinimas;
    }

    @Override
    public String toString() {
        return "Saldainis{" +
                "pavadinimas='" + pavadinimas + '\'' +
                ", ivertinimas=" + ivertinimas +
                '}';
    }

    @Override
    public int compareTo(Saldainis o) {
        if (ivertinimas > o.getIvertinimas()) {
            return 1;
        } else if (ivertinimas < o.getIvertinimas()) {
            return -1;
        }
        return 0;
    }
}
