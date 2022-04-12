package lt.bit;
//Gamtininkas registruoja likusius žiemoti paukščius. Jo tikslas yra
//nustatyti, kurios iš trijų paukščių rūšių atstovų liko žiemoti daugiausia. Klaviatūra įvedami trijų
//paukščių rūšių kiekiai, parašykite programą, kuri surikiuotų juos iš eilės nuo didžiausio iki
//mažiausio ir apskaičiuotų, kiek skiriasi didžiausias ir mažiausias kiekiai.

import java.util.Arrays;
import java.util.Scanner;

public class ZiemojantysPauksciai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite kiek kiekvienos rusies pauksciu liko ziemoti:");
        int pirma = sc.nextInt();
        int antra = sc.nextInt();
        int trecia = sc.nextInt();
        int arr[] = {0, 0, 0};
        arr[0] = pirma;
        arr[1] = antra;
        arr[2] = trecia;
        System.out.println("Kiekvienos rusies pauksciu liko ziemoti"+ Arrays.toString(arr));
        // Calling getMax() method for getting max value
        int max = getMax(arr);
        System.out.println("Daugiausia liko ziemoti: "+max);

        // Calling getMin() method for getting min value
        int min = getMin(arr);
        System.out.println("Maziausia liko ziemoti: "+min);
        int skirtumas = max - min;
        System.out.println("Skirtumas tarp didziausio ir maziausio kiekio: "+skirtumas);
    }
    // Method for getting the maximum value
    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value
    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }
}