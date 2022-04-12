package lt.bit;
//Petriukas per pusmetį gavo 5 matematikos pažymius. Mokytoja nusprendė
//padaryti vaikams staigmeną: mokiniai, kurių pažymių vidurkis yra didesnis už 9, gaus tris
//saldainius, o mokiniams, kurių vidurkis yra tarp 7 ir 9, įskaitant intervalo galus, bus apdovanoti
//dviem saldainiais. Visi likusieji gaus po vieną saldainį.
//Parašykite programą, kuri pagal įvestus Petriuko pažymius apskaičiuotų, kiek saldainių jis
//gaus.

import java.util.Scanner;

public class Matematika {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kokius pazymius gavo Petriukas?(iveskite 5 skaicius)");
        System.out.println("Pirmas pazymys ->");
        double pazymys1 = sc.nextDouble();
        System.out.println("Antras pazymys ->");
        double pazymys2 = sc.nextDouble();
        System.out.println("Trecias pazymys ->");
        double pazymys3 = sc.nextDouble();
        System.out.println("Ketvirtas pazymys ->");
        double pazymys4 = sc.nextDouble();
        System.out.println("Penktas pazymys ->");
        double pazymys5 = sc.nextDouble();
        double vidurkis = (pazymys1+pazymys2+pazymys3+pazymys4+pazymys5)/5;
        if (vidurkis>9){
            System.out.println("Petriukas gaus tris saldainius.");
        }else if (vidurkis>=7 && vidurkis<=9){
            System.out.println("Petriukas gaus du saldainius.");
        }else{
            System.out.println("Petriukas gaus viena saldaini.");
        }

    }
}
