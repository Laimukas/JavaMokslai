package lt.bit;

import java.util.Scanner;

public class LyginisNelyginis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite bet koki skaiciu (lygini arba nelygini)");
        double d_num = sc.nextDouble();

        if ((d_num % 1) == 0) {
            System.out.println("Tai lyginis skaicius");
        } else {
            System.out.println("Tai nelyginis skaicius");
        }
    }
}
