package lt.bit;
//Kazys ir Onutė tikra komanda: Kazys padeda Onutei ruoštis sporto
//rungčiai, kurioje Onutė šokinėja per virvutę. Ji kartoja šuoliukus m kartų ir pirmuoju bandymu
//atlieka k1, antruoju – k2, ..., m-tuoju – km šuoliukų. Parašykite programą, kuri padėtų Kaziui
//suskaičiuoti, kiek kartų iš viso Onutė peršoko per virvutę ir koks vidutinis vienu bandymu atliktų
//šuoliukų skaičius.

import java.util.Scanner;

public class SuoliaiPerVirvute {
    public static void main(String[] args) {
        int visoPrisokinejo = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Kiek kartu sokinejo: ");
        int bandymuKiekis = in.nextInt();
        for (int i = 1; i <= bandymuKiekis; i++) {
            System.out.println("Kiek sokinejo kartu " + i + " bandymu:");
            int sokinejoKartu = in.nextInt();
            visoPrisokinejo = visoPrisokinejo + sokinejoKartu;
        }
        int vidutiniskaiPrisokinejo = visoPrisokinejo / bandymuKiekis;
        System.out.println("Is viso: " + visoPrisokinejo);
        System.out.println("Vidutiniskai: " + vidutiniskaiPrisokinejo);
    }
}
