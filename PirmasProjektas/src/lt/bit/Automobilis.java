package lt.bit;
//Automobilių tunelio po Nepriklausomybės aikšte Vilniuje ilgis lygus 264 m.
//Parašykite programą, kuri apskaičiuotų, kelias sekundes s automobilis važiuoja šiuo tuneliu, jei
//jo greitis yra v km/h? Rezultatus pateikite šimtųjų tikslumu.

import java.util.Scanner;

public class Automobilis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Koks automobilio greitis?");
        double autGreitis = sc.nextDouble();
        double laikas = 0.264 / autGreitis ;
        System.out.println("Automobilis tuneli pravaziuos per " + laikas*3600 + " sekundziu.");
    }
}
