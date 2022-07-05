package Zmogus;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * zmoniu sarasas
     *
     * programa duoda pasirinkima:
     * 1. paziureti visus
     * 2. ivesti nauja
     * 3. istrinti
     * 0. baigti
     *
     * 1. perskaito is failo zmoniu sarasa,
     * surusiuoja pagal varda (jei vardai vienodi, tai pagal pavarde)
     * atspausdina i ekrana
     * 2. papraso ivesti varda ir pavarde
     * prideda ivesta zmogu prie esamo zmoniu saraso (faile)
     * 3. papraso nurodyti zmogu, kuri reikia istrinti
     * (reikia patiems sugalvoti buda, kaip nurodyti)
     * istrina is failo nurodyta zmogu
     */
    public static void printMeniu() {
        System.out.println("---------------------Menu------------------");
        System.out.println(" 1. paziureti visus");
        System.out.println(" 2. ivesti nauja");
        System.out.println(" 3. istrinti");
        System.out.println(" 0. baigti");
        System.out.print("Iveskite pasirinkima: ");
    }

    public static void main(String[] args) throws ZmoniuSarasoKlaidos {
        ZmoniuSarasas zmoniuSarasas = new ZmoniuSarasas();
        Scanner scanner = new Scanner(System.in);
            int komanda = 10;
            while (komanda != 0) {
                printMeniu();
                komanda = Integer.parseInt(scanner.nextLine());
                switch (komanda) {
                    case 1:
                        zmoniuSarasas.perziuretiZmones();
                        break;
                    case 2:
                        zmoniuSarasas.papildytiSarasa();
                        break;
                    case 3:
                        zmoniuSarasas.pasalintiIsSaraso();
                        break;
                    case 0:
                       break;
                }
            }
        }
    }

