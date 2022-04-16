package lt.bit.third.example;
// darbuojames su nauja uzduotim,biblioteku ir knygu aprasymas,duomenu istraukimas,uzduociu igyvendinimas
//Uzduotis: Parasyti programa "biblioteka". Kiekviena irasa sudaro laukai: autorius, pavadinimas, leidimo metai,
// knygos kodas, leidykla ir puslapiu skaicius. Turi buti realizuota 4 punktai -> aprasyti Bibliotekos klaseje.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Knyga pirmaKnyga = new Knyga("aut1", "Coding", 2005, "561616", "KaunoSpauda", 400);
        Knyga antraKnyga = new Knyga("aut2", "Java 4 dumb", 2010,"48464", "Raide", 600);
        Knyga treciaKnyga = new Knyga("aut3", "C++", 2012,"64466", "Rodiklis", 450);
        Knyga ketvirtaKnyga = new Knyga("aut1", "C++ ir kt.", 2015,"6455466", "Rodiklis", 350);
        Knyga penktaKnyga = new Knyga("aut1", "Oracle", 2016,"645666", "Rodiklis", 200);

        ArrayList<Knyga> knygos = new ArrayList<>();
        knygos.add(pirmaKnyga);
        knygos.add(antraKnyga);
        knygos.add(treciaKnyga);
        knygos.add(ketvirtaKnyga);
        knygos.add(penktaKnyga);

        Biblioteka biblioteka = new Biblioteka(knygos);

        biblioteka.getKnyguKiekisIrVidPuslapiuSkaicius("aut1");
        biblioteka.paieskaPagalAutoriausIrKnygosKoda("aut2", "48464");
        biblioteka.paieska("aut1", "6455466", "Rodiklis", 2015);
        biblioteka.knyguSarasoRikiavimasPagalPasirinktaLeidykla("KaunoSpauda");

    }
}
