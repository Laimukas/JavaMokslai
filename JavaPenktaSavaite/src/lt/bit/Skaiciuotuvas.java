package lt.bit;
//Danutė dirba buhaltere, todėl jai kartais reikia atlikti aritmetinius skaičiavimus
//su dideliais skaičių kiekiais. Ji skundžiasi, kad sunku ir nepatogu daug kartų spaudinėti
//skaičiuotuvo klavišus, todėl ji paprašė Jūsų, kad parašytumėte programą, kurios pradžioje
//pakaktų įvesti aritmetinio veiksmo simbolį, ir būtų galima įvedinėti skaičius, su kuriais bus
//atliekama ta operacija, operacijos pabaiga užfiksuojama įvedus nulį.
//Pavyzdžiui, Danutė išsirenka sumos skaičiavimo operaciją, tada įvedinėja skaičius, juos reikia
//sumuoti tol, kol įves nulį, tada baigti skaičiavimą ir pateikti rezultatą.
//Reikia sukurti skaičiuotuvą tokiems veiksmams atlikti: suma - 1, atimtis - 2, daugyba - 3,
//didžiausia reikšmė sraute - 4, mažiausia reikšmė sraute - 5. (Danutė įves veiksmą reiškiantį
//skaičių, nepamirškite jos informuoti įjungus programą, koks skaičius kokį veiksmą reikš).

import java.util.ArrayList;
import java.util.Scanner;

public class Skaiciuotuvas {
    public static void main(String[] args) {
        System.out.println("Veiksmai:1) suma;2) atimtis;3) daugyba;4) didziausia reiksme sraute;5) maziausia reiksme sraute.");
        //vedam skaiciu issiaiskinti kuri veiksma atliksim
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite veiksma zyminti skaiciu (0-5): ");
        int veiksmoIndeksas = in.nextInt();
        int max = Integer.MAX_VALUE;
        System.out.println("Veskite skaicius su kuriais bus atliekami veiksmai(parasius 0,bus ciklas uzdarytas ir atliekamas veiksmas):");
        //susikuriam skaiciu masyva

        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 1; i < max; i++) {
            int reiksme = in.nextInt();
            int j = i - 1;
            if (reiksme != 0) {
                al.add(reiksme);
            } else {
                max = i;
            }
        }
        System.out.print(al);
        if (veiksmoIndeksas == 1) {
            System.out.println("\nVeiksmo indeksas 1 -> skaiciu suma: " + apskaiciuojamSuma(al));
        } else if (veiksmoIndeksas == 2) {
            System.out.println("\nVeiksmo indeksas 2 -> skaiciu atimtis: " + apskaiciuojamAtimti(al));
        } else if (veiksmoIndeksas == 3) {
            System.out.println("\nVeiksmo indeksas 3 -> skaiciu daugyba: " + apskaiciuojamDaugyba(al));
        } else if (veiksmoIndeksas == 4) {
            System.out.println("\nVeiksmo indeksas 4 -> didziausias skaicius sraute: " + maximum(al));
        } else if (veiksmoIndeksas == 5) {
            System.out.println("\nVeiksmo indeksas 5 -> maziausias skaicius sraute: " + minimum(al));
        } else {
            System.out.println("\nVeiksmu aprasytu tokiu indeksu nera...");
        }
    }

    private static int apskaiciuojamSuma(ArrayList<Integer> al) {
        int sum = 0;
        for (int value : al) {
            sum += value;
        }
        return sum;
    }

    private static int apskaiciuojamAtimti(ArrayList<Integer> al) {
        int atimtis = 0;
        for (int value : al) {
            atimtis -= value;
        }
        return atimtis;
    }

    private static int apskaiciuojamDaugyba(ArrayList<Integer> al) {
        int daugyba = 1;
        for (int value : al) {
            daugyba = daugyba * value;
        }
        return daugyba;
    }

    public static int maximum(ArrayList<Integer> al) {
        int max = Integer.MIN_VALUE;

        for (int a : al) {
            if (a > max)
                max = a;
        }
        return max;
    }

    public static int minimum(ArrayList<Integer> al) {
        int min = Integer.MAX_VALUE;

        for (int a : al) {
            if (a < min)
                min = a;
        }
        return min;
    }
}
