package lt.bit;
//Statybininkui reikia pastatyti sieną, kurios ilgis yra a metrų, o aukštis h metrų
//(a ir h – sveikieji skaičiai). Kiek reikės plytų, kurių ilgis 20 cm, o aukštis 10 cm ir kiek kainuos
//plytos, jeigu vienos plytos kaina k Lt. Pinigų sumą pateikti šimtųjų tikslumu.

import java.util.Scanner;

public class Statybininkas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Koks sienos ilgis metrais?");
        double sienosIlgis = sc.nextDouble();
        System.out.println("Koks sienos aukstis metrais?");
        double sienosAukstis = sc.nextDouble();
        System.out.println("Kokia plytos kaina Lt?");
        double plytosKaina = sc.nextDouble();

        double plytuKiekis = (sienosIlgis*sienosAukstis)/(0.2*0.1);

        System.out.println("Reikalingas plytu kiekis yra: " + plytuKiekis);
        System.out.println("Plytos kainuos: " + plytuKiekis*plytosKaina + " Lt");
    }

}
