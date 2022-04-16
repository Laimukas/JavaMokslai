package lt.bit.fourth.example;

import java.util.ArrayList;
import java.util.Collections;

public class Sandelys {

    private ArrayList<Kompiuteris> kompiuteriai;

    public Sandelys(ArrayList<Kompiuteris> kompiuteriai) {
        this.kompiuteriai = kompiuteriai;
    }
// uzduoties 1 punktas -- visu pasirinkto gamintojo kompiuteriu kiekio ir vidutines kainos skaiciavimas

    public void getKompiuteriuKiekisIrVidKainosSkaicius(String gamintojas) {
        int kompiuteriuCounter = 0;
        int kainuSuma = 0;
        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (kompiuteris.getGamintojas().equals(gamintojas)) {
                kompiuteriuCounter++;
                kainuSuma += kompiuteris.getKaina();

            }
        }
        System.out.println("Uzduoties 1 punktas");
        System.out.println("Gamintojo: " + gamintojas + " kompiuteriu kiekis yra: " + kompiuteriuCounter);
        int vidKaina = kainuSuma / kompiuteriuCounter;
        System.out.println("Vidutine kaina yra: " + vidKaina);

    }
// uzduoties 2 punktas -- paieska pagal prekes koda ir gamintoja

    public void paieskaPagalPrekesKodaIrGamintoja(String prekesKodas, String gamintojas) {
        System.out.println("Uzduoties 2 punktas");
        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (paieska(kompiuteris, prekesKodas, gamintojas)) {
                System.out.println("Kompiuterio informacija: " + kompiuteris);
            }
        }
    }

    private boolean paieska(Kompiuteris kompiuteris, String prekesKodas, String gamintojas) {
        return kompiuteris.getPrekesKodas().equals(prekesKodas) && kompiuteris.getGamintojas().equals(gamintojas);
    }
// uzduoties 3 punktas -- paieska pagal prekes koda,gamintoja,kaina ir garantija

    public void paieska(String prekesKodas, String gamintojas, int kaina, int garantija) {
        System.out.println("Uzduoties 3 punktas");
        kompiuteriai.forEach(kompiuteris -> {
            if (paieska(kompiuteris, prekesKodas, gamintojas) && kompiuteris.getKaina() == kaina
                    && kompiuteris.getGarantija() == garantija) {
                System.out.println(kompiuteris);
            }
        });
    }

// uzduoties 4 punktas -- pasirinkto gamintojo prekiu saraso rikiavimas pagal kaina ir svori

    public void prekiuSarasoRikiavimasPagalPasirinktaGamintoja(String gamintojas) {
        System.out.println("Uzduoties 4 punktas");
        ArrayList<Kompiuteris> pasirinktoGamintojoPrekes = new ArrayList<>();

        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (kompiuteris.getGamintojas().equals(gamintojas)) {
                pasirinktoGamintojoPrekes.add(kompiuteris);
            }
        }
        Collections.sort(kompiuteriai, new RikiavimasPagalKaina());
        Collections.sort(kompiuteriai, new RikiavimasPagalSvori());

        pasirinktoGamintojoPrekes.forEach(kompiuteris -> System.out.println(kompiuteris));
    }

}
