package lt.bit;

import java.util.Arrays;

public class SkaiciaiMazesniUz10 {
    public static void main(String[] args) {
        int[] skaiciai = {5, 22, 13, 7, 10};
        int[] filtruotosReiksmes = filtruotiMazesniusUz10(skaiciai);
        for (int x : filtruotosReiksmes) {
            System.out.println(x);
        }
        System.out.println(Arrays.toString(filtruotosReiksmes));
    }

    public static int[] filtruotiMazesniusUz10(int[] masyvas) {
        int[] filtruoti = new int[masyvas.length];
        for (int i = 0; i < masyvas.length; i++) {
            if (masyvas[i] < 10) {
                filtruoti[i] = masyvas[i];
            }
        }
        return filtruoti;
    }
}
