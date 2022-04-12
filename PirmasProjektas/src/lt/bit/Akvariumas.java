package lt.bit;
//Akvariume gyvena a žuvų. Kiekvieną dieną Petriukas į akvariumą įdeda b
//žuvų. Parašykite programą, kuri suskaičiuotų kiek iš viso bus žuvų po n dienų. Rezultatą reikia
//išvesti su paaiškinamaisiais žodžiais.
import java.util.Scanner;

public class Akvariumas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek zuvu gyvena akvariume?");
        int zuvuGyvenaAkvariume = sc.nextInt();
        System.out.println("Kiek zuvu i akvariuma idedama kiekviena diena?");
        int zuvuIdedamaKasdien = sc.nextInt();
        System.out.println("Kiek dienu praejo?");
        int praejoDienu = sc.nextInt();

        int visosZuvys = zuvuGyvenaAkvariume + zuvuIdedamaKasdien*praejoDienu;
        System.out.println("Po " + praejoDienu + " dienu akvariume gyvens " + visosZuvys + " zuvu.");
    }
}
