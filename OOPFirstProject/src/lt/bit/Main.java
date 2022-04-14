package lt.bit;

import lt.bit.inheritance.PasaulioGyv;
import lt.bit.inheritance.Rase;
import lt.bit.inheritance.Statusas;
import lt.bit.inheritance.Zemynas;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        // naujas objektas / instance
        // kai prirasom new, kvieciame konstruktoriu
        Zmogus zmogus = new Zmogus("Vardenis", "Pavardenis",
                1989, 80.2, 175, "Vardeniukas",
                "Adresas", "+37062255555");

        Zmogus darVienasZmogus = new Zmogus("Vardenis", "Pavardenis",
                1996, 87.5, 180,
                "Vandenis", "Adresas", "+37062131231", "Lenkijos");

        zmogus.setVardas("Kukutis");
       System.out.println("Zmogaus vardas yra: " + zmogus.getVardas());

        Zmogus naujasZmogus = new Zmogus("Vardenis", "Pavardenis",
                1989, 80.2, 175, "Vardeniukas",
                "Adresas", "+37062255555");
        System.out.println("Zodiakas: "+zmogus.getZodiakoZenklas());

        //Veiksmai is matematiniu uzduociu
        MathUtils.add(5, 3);
                //System.out.println(MathUtils.division(7, 3));

        //Funkcijos apjungiant Sunkvezimiu ir Modeliu klases
        MBSunkvezimis mbSunkvezimis = new MBSunkvezimis(MBModeliai.ACTROS);
        System.out.println("MB Sunkvezimiu modeliai-> "+Arrays.asList(MBModeliai.values()));

        //Apsirasom norima gauti atsakyma is Vandens Agr.Busenos klases
        VandensAgregatinesBusenos.SKYSTOJI.getTemperatura();
        System.out.println("Vanduo virsta vandeniu nuo "+VandensAgregatinesBusenos.SKYSTOJI.getTemperatura()+" temperaturos.");

        //Priskiriu ir istraukiu reiksmes is inheritance package'o
        PasaulioGyv pasaulioGyv = new PasaulioGyv("Petras", "Jonaitis",
                1989, 80.2, 175, Rase.BALTAODIS,
                Statusas.DEPUTATAS, Zemynas.SIAURES_AMERIKA);
        System.out.println(pasaulioGyv);
    }
}
