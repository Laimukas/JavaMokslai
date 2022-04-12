package lt.bit;
//Parašykite programą, kuri suskaičiuotų, kelis kartus keltui teks kelti per upę k
//automobilių, jeigu vienu metu jis gali perkelti m automobilių. Keltas kelia tik tada, kai yra
//pilnas (susidaro m automobilių.) Taip pat išveskite automobilių skaičių, kuriems persikelti per
//upę nepavyks (jei buvo 11 automobilių, o į keltą telpa 10, tai 10 perkels, o vienas liks
//neperkeltas).

import java.util.Scanner;

public class Keltas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite automobiliu skaiciu:");
        double autoSkaicius = sc.nextDouble();
        System.out.println("Kiek automobiliu telpa i kelta?");
        double autoTelpaKelte = sc.nextDouble();
        double perkelsAutoPerKartus = autoSkaicius / autoTelpaKelte;
        int lyginiaiKartai = (int) perkelsAutoPerKartus;
        double liksNeperkelta = autoSkaicius - lyginiaiKartai * autoTelpaKelte;
        int liksLyginisAutoSkaicius = (int) liksNeperkelta;

        if (perkelsAutoPerKartus == (int) perkelsAutoPerKartus) {
            //tikrinam ar gaunasi dalyboje lyginis ar nelyginis skaicius
            //siuo atveju skaicius turi buti lyginis,seka ir atitinkamas atsakymas
            System.out.println("Perkels auto per " + lyginiaiKartai +
                    " kartus. Neperkeltu automobiliu nebus.");
        } else {

            System.out.println("Perkels auto per " + lyginiaiKartai +
                    " kartus. Liks neperkelti " + liksLyginisAutoSkaicius + " automobiliai.");
        }
    }
}
