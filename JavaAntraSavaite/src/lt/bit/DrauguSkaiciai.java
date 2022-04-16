package lt.bit;
//10 draugų sugalvojo po vieną skaičių iki 100 ir juos užrašė ant kortelių.
//Parašykite programą, surandančią keli draugai sugalvojo lyginius skaičius. Jeigu tokių skaičių
//bus, ekrane turi būti rodomas jų kiekis, priešingu atveju ekrane turi būti rodomas žodis Nėra.


import java.util.Scanner;

public class DrauguSkaiciai {
    public static void main(String[] args) {
        int lyginiuSkaiciuKiekis = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite 10 draugu sugalvotus skaicius iki 100: ");
        for (int i = 1; i <= 10; i++) {
            //   System.out.println(i + " skaicius yra:");
            int skaicius = in.nextInt();
            if (skaicius % 2 == 0) {
                lyginiuSkaiciuKiekis = lyginiuSkaiciuKiekis + 1;
            }
        }
        if (lyginiuSkaiciuKiekis == 0) {
            System.out.println("Lyginiu skaiciu nera");
        } else {
            System.out.println("Lyginiu skaiciu yra: " + lyginiuSkaiciuKiekis);
        }


    }
}

