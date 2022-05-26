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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class Filmas implements Comparable<Filmas>{

    private String pavadinimas;
    private Integer metai;
    private LocalTime trukme;
    private Integer ziurovuSkaiciusMln;

    public Filmas(String pavadinimas, Integer metai, LocalTime trukme, Integer ziurovuSkaiciusMln) {
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

    public Integer getMetai() {
        return metai;
    }

    public void setMetai(Integer metai) {
        this.metai = metai;
    }

    public LocalTime getTrukme() {
        return trukme;
    }

    public void setTrukme(LocalTime trukme) {
        this.trukme = trukme;
    }

    public Integer getZiurovuSkaiciusMln() {
        return ziurovuSkaiciusMln;
    }

    public void setZiurovuSkaiciusMln(Integer ziurovuSkaiciusMln) {
        this.ziurovuSkaiciusMln = ziurovuSkaiciusMln;
    }

    @Override
    public String toString() {
        return "{"+
                "'" + pavadinimas + '\'' +
                ", metai=" + metai +
                ", trukme=" + trukme +
                ", ziurovuSkaiciusMln=" + ziurovuSkaiciusMln +
                "}\n";
    }
    //1 - dabartinis filmas yra auksciau Filmas o
    //0 - abu filmai pagal rikiavima lygus
    //-1 - dabartinis filmas yra zemiau Filmas o
    @Override
    public int compareTo(Filmas o) {
        //surikiuoti pagal trukme didejancia tvarka
        int res = trukme.compareTo(o.getTrukme());
        // ------ Variantas 1 ------------
//        //cia didejancia
//        if(res > 0){
//            return 1;
//        }else if (res <0){
//            return -1;
//        }
//        //jei lygu pagal ziurovuSkaiciuMln mazejancia tvarka
//        res = ziurovuSkaiciusMln.compareTo(o.getZiurovuSkaiciusMln());
//        //cia mazejancia
//        if(res > 0){
//            return -1;
//        }else if (res <0){
//            return 1;
//        }
//        return 0;

        //----------Variantas 2 ------------------

        if(res !=0) {
            return res;
        }
        //jei lygu pagal ziurovuSkaiciuMln mazejancia tvarka
        return -ziurovuSkaiciusMln.compareTo(o.getZiurovuSkaiciusMln());
    }


}
