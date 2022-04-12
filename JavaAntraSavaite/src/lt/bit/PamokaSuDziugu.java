package lt.bit;

import java.util.Scanner;

public class PamokaSuDziugu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //-----1uzduotis
        /*
        int[] sveikiejiSkaiciai = new int[10];
        sveikiejiSkaiciai[0]=1;
        sveikiejiSkaiciai[4]=99;
        sveikiejiSkaiciai[sveikiejiSkaiciai.length -1]=100;

        spausdintiSveikuosiusSkaicius(sveikiejiSkaiciai);//iskvieciam funkcija kuria apsirasem apacioj,kuri saugoma musu atminti
    }

    public static void spausdintiSveikuosiusSkaicius(int[] x){
        for (int i=0;i<x.length; i++){
            System.out.println(x[i]);
            //jei norim kad visad spausdintu 99,apsirasom taip
            System.out.println(x[4]);
        }*/
        //------2Uzduotis
/*
        double suma = skaiciuSuma(2.0, 4.0);
        System.out.println(suma);
    }

    public static double skaiciuSuma(double x, double y) {
        double suma = x + y;
        return suma;
*/

        //-----3Uzduotis
     /*   int skaicius = 101;
        System.out.println("skaicius buvo: "+skaicius + " " + arLyginis(skaicius));

    }

    public static boolean arLyginis(int x) {

        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }*/

        //---------4uzduotis
        //turint masyva sudet elementus ir veliau gaut ju vidurki
/*
        int[] masyvas = new int[]{2, 3, 999, 6};

        double vid = masyvoElementuVidurkis(masyvas);
        System.out.println("Masyvo vidurkis: " + vid);

    }

    public static double masyvoElementuSuma(int[] x) {
        double suma = 0;
        for (int i = 0; i < x.length; i++) {
            //suma = suma + x[i];
            suma += x[i];
           System.out.println(x[i]);
        }
        return suma;
    }

    public static double masyvoElementuVidurkis(int[] x) {
        double suma = masyvoElementuSuma(x);
        //return 1.0 * suma/x.length; //pats primityviausias budas versti i double tipa
        return suma / x.length;
        */

        //--------NamuDarbas
        // Sukurti metoda apskaiciuotiPerimetra(x, y)
        // Sukurti metoda apskaiciuotiPlota(x, y)
        // Iskviesti is main ir atspausdinti rezultata kai krastine x = 4, o krastine y = 3.6
     /*/   double perimetras = staciakampioPerimetras(4, 3.6);
        double plotas = staciakampioPlotas(4,3.6);

        System.out.println("Perimetras: "+perimetras);
        System.out.println("Plotas: "+plotas);

    }

    public static double staciakampioPerimetras(double x, double y) {
        double stacPer = 2 * (x + y);
        return stacPer;

    }

    public static double staciakampioPlotas(double a, double b) {
        double stacPlo = a * b;
        return stacPlo;
*/
    }


}