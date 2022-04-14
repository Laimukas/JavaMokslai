package lt.bit;
//Prieš Kalėdas miško urėdijos prekiauja įvairaus aukščio eglutėmis. Į
//prekybos vietą atvežta n eglučių. Jų aukščiai yra e1, e2, …, en. Parašykite programą,
//skaičiuojančią vidutinį eglutės aukštį.

import java.util.Scanner;

public class KaledinesEglutes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Kiek egluciu atvezta? ");
        int egluciuKiekis = in.nextInt();
        double auksciuSuma=0;
        double auksciuVidurkis;

        for (int i = 1; i <= egluciuKiekis; i++) {
            System.out.println("Iveskite " + i + " eglutes auksti: ");
            double eglutesAukstis = in.nextDouble();
            auksciuSuma = auksciuSuma + eglutesAukstis;
        }

        auksciuVidurkis=auksciuSuma/egluciuKiekis;
        System.out.println("Egluciu auksciu vidurkis yra: "+auksciuVidurkis);

    }
}
