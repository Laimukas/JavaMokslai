package lt.bit;

import java.util.Arrays;

public class SkaiciuFiltravimas {
    public static void main(String[] args) {
        int[] skaiciai = {2, 99, 100, 8, 5, 9, -2, 0};
        int[] didesniUz5 = filtruotiDidesniusUz5(skaiciai);
        System.out.println("Turimas masyvas -> " + Arrays.toString(skaiciai));
        System.out.println("Didesni uz 5 -> " + Arrays.toString(didesniUz5));

        int[] teigiami = filtruotiDidesniusUz(skaiciai, 0);
        System.out.println("Visi teigiami -> " + Arrays.toString(teigiami));

        int[] didesniUz100 = filtruotiDidesniusUz(skaiciai, 100);
        System.out.println("Didesni uz 100 -> " + Arrays.toString(didesniUz100));

//        int[]laikinas = new int[0];
//        System.out.println(Arrays.toString(laikinas));
//        laikinas=add(laikinas,5);
//        laikinas=add(laikinas,99);
//        System.out.println(Arrays.toString(laikinas));
    }

    public static int[] filtruotiDidesniusUz5(int[] x) {
        //Susikurti masyva kur desim atfiltruotas reiksmes
        int[] filtruoti = new int[0];
        //sukam cikla per visas masyvo reiksmes
        for (int i = 0; i < x.length; i++) {
            //tikrinam su if ar skaicius didesnis uz 5
            if (x[i] > 5) {
                //dedam reiksme i savo susikurta masyva
                filtruoti = add(filtruoti, x[i]);
            }
        }
        //grazinam masyva
        return filtruoti;
    }

    public static int[] filtruotiDidesniusUz(int[] masyvas, int reiksme) {
        int[] filtruoti = new int[0];
        for (int i = 0; i < masyvas.length; i++) {
            if (masyvas[i] > reiksme) {
                filtruoti = add(filtruoti, masyvas[i]);
            }
        }
        return filtruoti;
    }

    public static int[] add(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }
}
