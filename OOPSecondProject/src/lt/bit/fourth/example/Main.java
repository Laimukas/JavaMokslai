package lt.bit.fourth.example;
//Uzduotis: Parasyti programa "kompiuteriai". Kiekviena irasa sudaro laukai: prekes kodas, gamintojas, kaina,
// svoris, garantija (metais). Turi buti realizuota 4 punktai -> aprasyti Sandelys klaseje.

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Kompiuteris pirmasKompiuteris = new Kompiuteris("1526", "Lenovo", 300, 2, 1);
        Kompiuteris antrasKompiuteris = new Kompiuteris("6548", "Acer", 350, 3, 2);
        Kompiuteris treciasKompiuteris = new Kompiuteris("3547", "Apple", 400, 3, 2);
        Kompiuteris ketvirtasKompiuteris = new Kompiuteris("2546", "Acer", 450, 4, 2);
        Kompiuteris penktasKompiuteris = new Kompiuteris("9512", "Lenovo", 400, 3, 2);

        ArrayList<Kompiuteris> kompiuteriai=new ArrayList<>();
        kompiuteriai.add(pirmasKompiuteris);
        kompiuteriai.add(antrasKompiuteris);
        kompiuteriai.add(treciasKompiuteris);
        kompiuteriai.add(ketvirtasKompiuteris);
        kompiuteriai.add(penktasKompiuteris);

        Sandelys sandelys = new Sandelys(kompiuteriai);

        sandelys.getKompiuteriuKiekisIrVidKainosSkaicius("Lenovo");
        sandelys.paieskaPagalPrekesKodaIrGamintoja("3547","Apple");
        sandelys.paieska("2546", "Acer", 350, 2);
        sandelys.prekiuSarasoRikiavimasPagalPasirinktaGamintoja("Acer");

    }
}
