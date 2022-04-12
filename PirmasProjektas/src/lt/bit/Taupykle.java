package lt.bit;
//Jonas turi kiaulę taupyklę, kurioje yra a monetų po 5 ct, b monetų po 20 ct ir c
//monetų po 2 Lt. Kitokios vertės monetų taupyklėje nėra. Parašykite programą, kuri
//suskaičiuotų, kiek pinigų kiaulėje taupyklėje iš viso turi Jonas. Atsakymą pateikite litais, pvz.:
//kai taupyklėje yra 12 monetų po 5 ct, 5 monetos po 20 ct ir 6 monetos po 2 Lt, tuomet ekrane
//turi būti rodoma: Taupyklėje yra 13.60 Lt.

import java.util.Scanner;

public class Taupykle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek yra monetu po 5 cnt?");
        double monetuPoPenkis = sc.nextDouble();
        System.out.println("Kiek yra monetu po 20 cnt?");
        double monetuPoDvim = sc.nextDouble();
        System.out.println("Kiek yra monetu po 2 Lt?");
        double monetuPoDu = sc.nextDouble();

        double sum = monetuPoPenkis*5 + monetuPoDvim*20 + monetuPoDu*200;
        System.out.println("Taupykleje yra " + sum/100 + " Lt.");

    }
}
