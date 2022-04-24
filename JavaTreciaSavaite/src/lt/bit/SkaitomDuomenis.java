package lt.bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SkaitomDuomenis {
    public static void main(String[] args) {
        //Nusiskaitom duomenis ir issaugom juos
        int[] skaiciai = skaitom("JavaTreciaSavaite/src/lt/bit/skaiciai.txt");
        System.out.println("Masyvas -> "+Arrays.toString(skaiciai));
        //suma
        int iskviestaSuma = suma(skaiciai);
        System.out.println("Masyvo skaiciu suma = " +iskviestaSuma);
        //vidurkis
        double iskviestasVidurkis = vidurkis(iskviestaSuma,skaiciai.length);
        System.out.println("Masyvo skaiciu vidurkis = "+iskviestasVidurkis);
        //min
        int iskviestasMin = min(skaiciai);
        System.out.println("Min masyvo reiksme yra = "+iskviestasMin);
        //max
        int iskviestasMax = max(skaiciai);
        System.out.println("Max masyvo reiksme yra = "+iskviestasMax);
    }

    public static int[] skaitom(String failoKelias) {
        int[] masyvas = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(failoKelias));
            String eilute = br.readLine();
            int masyvoIlgis = Integer.parseInt(eilute);
            masyvas = new int[masyvoIlgis];
            String eilute2 = br.readLine();
            String[] reiksmes = eilute2.split(",");
            for (int i = 0; i < masyvoIlgis; i++) {
                masyvas[i] = Integer.parseInt(reiksmes[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return masyvas;
    }

    //    public static int[] apskaiciuojamMasyvoSuma(String failoKelias) {
//        int[] masyvas =null;
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(failoKelias));
//            String eilute = br.readLine();
//            int masyvoIlgis = Integer.parseInt(eilute);
//            masyvas = new int[masyvoIlgis];
//            String eilute2 = br.readLine();
//            String[] reiksmes = eilute2.split(",");
//            for (int i=0;i<masyvoIlgis;i++){
//                masyvas[i]=Integer.parseInt(reiksmes[i]);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return masyvas;
//    }
//
//    public static int grazinamMasyvoSuma(int[] array) {
//        int sum = 0;
//        for (int value : array) {
//            sum += value;
//        }
//        return sum;
//    }
//    public static double surandamVidurki(int[] array) {
//        int sum = surandamVidurki(array);
//        return (double) sum / array.length;
//    }
    public static int suma(int[] x) {
        int suma = 0;
        for (int i = 0; i < x.length; i++) {
            suma = suma + x[i];
        }
        return suma;
    }

    public static double vidurkis(int suma, int elementuKiekis) {
        return 1.0 * suma / elementuKiekis;
    }

    public static int min(int[] masyvas) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < masyvas.length; i++) {
            if (masyvas[i] < min) {
                min = masyvas[i];
            }
        }
        return min;
    }
    public static int max(int[] masyvas) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < masyvas.length; i++) {
            if (masyvas[i] > max) {
                max = masyvas[i];
            }
        }
        return max;
    }
}
