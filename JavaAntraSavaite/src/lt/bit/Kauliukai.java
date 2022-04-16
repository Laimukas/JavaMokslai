package lt.bit;
//Tomas dalyvauja loterijoje. Jis meta n standartinių lošimo kauliukų (ant jų sienelių
//skaičiai nuo 1 iki 6). Kiekvieno skaičiaus iškritimo tikimybė yra vienoda. Loterija laimima tada,
//jei Tomo išridentų skaičių suma yra didesnė nei pusė visos galimos taškų sumos. Parašykite
//programą, kuri nustatytų:
// koks maksimalus taškų kiekis;
// kiek iš viso taškų surinko Tomas;
// koks jo surinktų taškų vidurkis
// ar berniukas laimėjo loterijoje.
//Pradiniai duomenys – kauliukų kiekis n ir išridentas kiekvieno kauliuko skaičius.

import java.util.Scanner;

public class Kauliukai {
    public static void main(String[] args) {
        int visoSurinktiGalima = 0;
        int surinkoTasku = 0;
        double vidurkis = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite kauliuku kieki: ");
        int kauliukuKiekis = in.nextInt();
        for (int i = 1; i <= kauliukuKiekis; i++) {
            System.out.println(i + "-o kauliuko tasku kiekis:");
            int kauliukoTaskuKiekis = in.nextInt();
            visoSurinktiGalima = visoSurinktiGalima + 6;
            surinkoTasku = surinkoTasku + kauliukoTaskuKiekis;

        }
        vidurkis = 1.0 * surinkoTasku / kauliukuKiekis;
        if (vidurkis > 3) {
            System.out.println("Is viso galima surinkt tasku: " + visoSurinktiGalima);
            System.out.println("Tomas is viso surinko: " + surinkoTasku);
            System.out.println("Jo tasku vidurkis: " + vidurkis);
            System.out.println("Loterija laimeta.");
        } else {
            System.out.println("Is viso galima surinkt tasku: " + visoSurinktiGalima);
            System.out.println("Tomas is viso surinko: " + surinkoTasku);
            System.out.println("Jo tasku vidurkis: " + vidurkis);
            System.out.println("Loterija pralaimeta.");
        }
    }
}
