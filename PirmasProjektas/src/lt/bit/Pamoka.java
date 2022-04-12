package lt.bit;
//<<< uzduotis >>>
//1. Pamoka. Parašykite programą, kuri padėtų Petriukui suskaičiuoti, kiek pamokų jis turi per
// savaitę ir kiek tai sudarys minučių. Klaviatūra įvedami 5 skaičiai, reiškiantys kiekvienos dienos
// pamokų skaičių.
import java.util.Scanner;

public class Pamoka {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek pamoku yra pirmadieni?");
        int pamokuKiekisPirmadieni = sc.nextInt();
        System.out.println("Kiek pamoku yra antradieni?");
        int pamokuKiekisAntradieni = sc.nextInt();
        System.out.println("Kiek pamoku yra treciadieni?");
        int pamokuKiekisTreciadieni = sc.nextInt();
        System.out.println("Kiek pamoku yra ketvirtadieni?");
        int pamokuKiekisKetvirtadieni = sc.nextInt();
        System.out.println("Kiek pamoku yra penktadieni?");
        int pamokuKiekisPenktadieni = sc.nextInt();

        int visosPamokos = pamokuKiekisPirmadieni
                + pamokuKiekisAntradieni
                + pamokuKiekisTreciadieni
                + pamokuKiekisKetvirtadieni
                + pamokuKiekisPenktadieni;
        System.out.println("Pamoku skaicius " + visosPamokos);

        int minutes = visosPamokos * 45;
        System.out.println("Viso minuciu sudaro " + minutes);
        // arba tiesiog be int apsirasymo galima parasyt atsakyma taip
        // System.out.println("Viso minuciu sudaro " + visosPamokos*45);
        // bet del grazumo apsirasom viska

    }
}
