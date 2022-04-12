package lt.bit;
//Parašykite programą, kuri, įvedus trapecijos pagrindų a ir b bei aukštinės
//h ilgius, apskaičiuotų trapecijos plotą.

import java.util.Scanner;

public class TrapecijosPlotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("!!! Kadangi naudoju int o ne double, iveskite teigiamus skaicius !!!");
        System.out.println("Koks trapecijos ilgesnio pagrindo ilgis?");
        int ilgesnisPagr = sc.nextInt();
        System.out.println("Koks trapecijos trumpesnio pagrindo ilgis?");
        int trumpesnisPagr = sc.nextInt();
        System.out.println("Koks trapecijos aukstines ilgis?");
        int aukstine = sc.nextInt();

        int plotas = ((ilgesnisPagr+trumpesnisPagr)/2)*aukstine;
        System.out.println("Trapecijos plotas yra: " +plotas);
    }
}
