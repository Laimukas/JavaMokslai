package lt.bit.IdomiausiFilmai;
//„Oskaro“ apdovanojimas teikiamas už nuopelnus kine. Nuo 1986 m.
//apdovanojimo ceremonija yra transliuojama per televiziją. Internete Adomas surado informaciją
//apie „Oskaro“ nominacijas pelniusius geriausius filmus ir nusprendė peržiūrėti apdovanojimų
//ceremonijų transliacijų įrašus. Sukurkite programą, kuri filmus surikiuotų pagal tokias taisykles:
//apdovanojimų ceremonijų transliacijos laiko didėjimo tvarka, o jei kelių filmų apdovanojimų
//ceremonijos transliacijos laikai sutampa, tuomet pagal žiūrovų skaičių mažėjimo tvarka.
//Pradinių duomenų faile Duomenys.txt:
//pirmoje eilutėje įrašytas apdovanojimų ceremonijų skaičius n;
//tolesnėse n eilučių įrašyta informacija apie vieną apdovanojimų ceremoniją: metai, filmo
//pavadinimas (gali sudaryti keli žodžiai, skiriamos 25 pozicijos), transliacijos laikas
//valandomis ir minutėmis (du sveikieji skaičiai), žiūrovų skaičius milijonais (sveikasis
//skaičius);
//Rezultatų faile Rezultatai.txt turi būti įrašytas laikantis užduoties reikalavimų surikiuotų filmų
//sąrašas. Vienam filmui skiriama viena eilutė.
//Reikalavimai programai:
//1. naudokite struktūras (įrašus) ir jų masyvus;
//2. sukurkite pradinių duomenų skaitymo procedūrą (funkciją void C++);
//3. sukurkite rikiavimo pagal du raktus procedūrą (funkciją void C++);
//4. sukurkite rezultatų rašymo į failą procedūrą (funkciją void C++).

import java.time.LocalTime;

public class Filmas {

    private String pavadinimas;
    private int metai;
    private LocalTime trukme;
    private int ziurovuSkaiciusMln;

    public Filmas(String pavadinimas, int metai, LocalTime trukme, int ziurovuSkaiciusMln) {
        this.pavadinimas = pavadinimas;
        this.metai = metai;
        this.trukme = trukme;
        this.ziurovuSkaiciusMln = ziurovuSkaiciusMln;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getMetai() {
        return metai;
    }

    public void setMetai(int metai) {
        this.metai = metai;
    }

    public LocalTime getTrukme() {
        return trukme;
    }

    public void setTrukme(LocalTime trukme) {
        this.trukme = trukme;
    }

    public int getZiurovuSkaiciusMln() {
        return ziurovuSkaiciusMln;
    }

    public void setZiurovuSkaiciusMln(int ziurovuSkaiciusMln) {
        this.ziurovuSkaiciusMln = ziurovuSkaiciusMln;
    }

    @Override
    public String toString() {
        return "{"+
                "'" + pavadinimas + '\'' +
                ", metai=" + metai +
                ", trukme=" + trukme +
                ", ziurovuSkaiciusMln=" + ziurovuSkaiciusMln +
                '}';
    }
}
