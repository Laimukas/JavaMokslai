package lt.bit;
// Jonukas žino, kad mokytoja jam gali duoti spręsti vieną iš trijų kontrolinio
//darbo variantų. Atlikdamas užduotį jis gaus du skaičius a ir b, o jam reikės apskaičiuoti x
//reikšmę pagal vieną iš trijų formulių.
//Pirmas variantas: x = ab+3;
//Antras variantas: x = a+b;
//Trečias variantas: x = a-b.
//Parašykite programą, kuri padėtų Jonukui pasitikrinti, ar jis teisingai skaičiuoja x reikšmę
//spręsdamas kiekvieno varianto užduotį.

import java.util.Scanner;

public class JonukoProblema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite uzduoties varianta.");
        int variantas = sc.nextInt();
        System.out.println("Iveskite a reiksme.");
        int a = sc.nextInt();
        System.out.println("Iveskite b reiksme.");
        int b = sc.nextInt();
        int x = 0;
        if (variantas == 1) {
            x = a * b + 3;
            System.out.println("Variantas: "+variantas+"; a = "+a+"; b = "+b+"; x=ab+3; Atsakymas: x = " + x+";");
        } else if (variantas == 2) {
            x = a+b;
            System.out.println("Variantas: "+variantas+"; a = "+a+"; b = "+b+"; x=a+b; Atsakymas: x = " + x+";");
        } else{
            x = a-b;
            System.out.println("Variantas: "+variantas+"; a = "+a+"; b = "+b+"; x=a-b; Atsakymas: x = " + x+";");
        }


    }

}


