package lt.bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SkaitomDuomenis {
    public static void main(String[] args) {
        //Nusiskaitom duomenis ir issaugom juos
        int[]skaiciai = skaitom("JavaTreciaSavaite/src/lt/bit/skaiciai.txt");
        System.out.println(Arrays.toString(skaiciai));
        //suma

        //vidurkis

        //min

        //max

    }

    public static int[] skaitom(String failoKelias) {
        int[] masyvas =null;

        try{
            BufferedReader br = new BufferedReader(new FileReader(failoKelias));
           String eilute = br.readLine();
           int masyvoIlgis = Integer.parseInt(eilute);
           masyvas = new int[masyvoIlgis];
            String eilute2 = br.readLine();
            String[] reiksmes = eilute2.split(",");
            for (int i=0;i<masyvoIlgis;i++){
                masyvas[i]=Integer.parseInt(reiksmes[i]);
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
}
