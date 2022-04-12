package lt.bit;

//<<< uzduotis >>>
//1. Pamoka. Parašykite programą, kuri padėtų Petriukui suskaičiuoti, kiek pamokų jis turi per
// savaitę ir kiek tai sudarys minučių. Klaviatūra įvedami 5 skaičiai, reiškiantys kiekvienos dienos
// pamokų skaičių.
import java.util.Scanner;

public class PamokaKieciau {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek pamoku yra pirmadieni?");
        int rezultatas = sc.nextInt();
        System.out.println("Kiek pamoku yra antradieni?");
        rezultatas += sc.nextInt();
        System.out.println("Kiek pamoku yra treciadieni?");
        rezultatas += sc.nextInt();
        System.out.println("Kiek pamoku yra ketvirtadieni?");
        rezultatas += sc.nextInt();
        System.out.println("Kiek pamoku yra penktadieni?");
        rezultatas += sc.nextInt();

        System.out.println("Pamoku skaicius " + rezultatas);

        int minutes = rezultatas * 45;
        System.out.println("Viso minuciu sudaro " + minutes);
        // arba tiesiog be int apsirasymo galima parasyt atsakyma taip
        // System.out.println("Viso minuciu sudaro " + rezultatas*45);
        // bet del grazumo apsirasom viska
    }
}
