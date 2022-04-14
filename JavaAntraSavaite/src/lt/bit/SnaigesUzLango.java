package lt.bit;
//Per atostogas Simas turėjo daugiau laisvo laiko ir nutarė suskaičiuoti, kiek
//sningant po jo namo langu nukrenta snaigių. Jis pastebėjo, kad kiekvieną kitą sekundę nukrenta
//dvigubai daugiau snaigių, nei prieš tai buvusią. Parašykite programą, skaičiuojančią kiek snaigių
//s bus nukritę per n sekundžių, kai per pirmąją sekundę nukrito k snaigių.

import java.util.Scanner;

public class SnaigesUzLango {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Kiek snaigiu nukrito per pirmaja sekunde? ");
        int pirmaSekundeNukritoSnaigiu = in.nextInt();
        System.out.println("Kiek sekundziu snigo? ");
        int snigoSekundziu = in.nextInt();
        int kitaSekundeNukritoSnaigiu = pirmaSekundeNukritoSnaigiu;
        int snaigiuSuma = pirmaSekundeNukritoSnaigiu;

        for (int i = 1; i < snigoSekundziu; i++) {
            kitaSekundeNukritoSnaigiu = kitaSekundeNukritoSnaigiu * 2;
            snaigiuSuma = snaigiuSuma + kitaSekundeNukritoSnaigiu;
        }
        System.out.println("Snaigiu nukrito: " + snaigiuSuma);
    }
}
