package lt.bit;
//Per matematikos pamoką teko nustatyti, kurie iš duotųjų teigiamų skaičių a, b ir c
//yra skaičiaus trys kartotiniai. Jei yra keli, reikia išvesti pirmą rastą, jeigu nėra nei vieno, reikia
//išvesti - nėra.
//Parašykite programą, sprendžiančią šį uždavinį.

import java.util.Scanner;

public class Skaiciai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite a reiksme.");
        int a = sc.nextInt();
        System.out.println("Iveskite b reiksme.");
        int b = sc.nextInt();
        System.out.println("Iveskite c reiksme.");
        int c = sc.nextInt();

        if (a % 3 == 0 ){
            System.out.println("Atsakymas: "+a);
        }else if (b% 3 == 0 ){
            System.out.println("Atsakymas: "+b);
        }else if (c% 3 == 0 ){
            System.out.println("Atsakymas: "+c);
        }else {
            System.out.println("Atsakymas: nera");
        }


    }
}
