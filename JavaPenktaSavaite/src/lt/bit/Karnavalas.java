package lt.bit;
//Mokykloje rengiamas karnavalas. Prieš karnavalą visi mokiniai turėjo pasiruošti
//kaukes. Kiekvieno mokinio kaukė buvo įvertinta tam tikru balu nuo 1 iki 10 (įvertinimai
//sveikieji skaičiai). Karnavalo dieną. visi į karnavalą atvykę mokiniai, turėjo pranešti, kokius
//įvertinimus gavo. Į karnavalą galėjo patekti tik tie mokiniai, kurių kaukės įvertintos ne mažiau
//kaip 5 balais.
//Kiek mokinių atvyko į karnavalą yra nežinoma. Parašykite programą, kuri suskaičiuotų keli
//mokiniai iš viso bandė patekti į karnavalą, ir keli iš jų pateko.
//Pastaba: Turėtų būti įvedinėjami kiekvieno mokinio kaukės įvertinimo balai. Duomenų įvedimas
//baigiamas nuliu.

import java.util.Scanner;

public class Karnavalas {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int didesniuUz5 = 0;
        int mokiniuKiekis = 0;
        System.out.println("Iveskite kokius balus gavo mokiniai(ivedus 0 ciklas nutruks): ");
        for (int i = 1; i < max; i++) {
            Scanner in = new Scanner(System.in);
            double balai = in.nextDouble();
            if (balai != 0 && balai >= 5) {
                didesniuUz5++;
                mokiniuKiekis++;
            } else if (balai != 0) {
                mokiniuKiekis++;
            } else {
                max = i;
            }
        }
        System.out.println("I karnavala ejo " + mokiniuKiekis + " mokiniai, pateko " + didesniuUz5);
    }
}
