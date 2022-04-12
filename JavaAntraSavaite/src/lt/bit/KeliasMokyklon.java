package lt.bit;
//Kiekvieną dieną Petriukas, eidamas į mokyklą, skaičiuoja kiekvieną savo
//žingsnį ir žaidžia tokį žaidimą: kai žingsnių skaičius baigiasi nuliu, Petriukas suploja rankomis, o
//kai penketu - spragteli pirštais. Parašykite programą, kuri suskaičiuotų, kiek kartų Petriukas
//suplos rankomis ir kiek – spragtels pirštais, jei jam iki mokyklos yra lygiai n žingsnių.

import java.util.Scanner;

public class KeliasMokyklon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Zingsniu kiekis: ");
        int zingsniai = in.nextInt();
        int suploja = 0;
        int spragteli = 0;
        int num =0;

        for (int i = 1; i < zingsniai + 1; i++) {

            if ((i % 5) == 0 && (i % 2) == 0) {//cia dar ir lyginis gaunasi,tad reiskias ir is 10 dalinasi :)
                num = num + 1;
                suploja = suploja + 1;

            } else if(i % 5 == 0 ){// o cia nelyginis,reiskias is 10 nesidalina :)
                num = num + 1;
                spragteli = spragteli + 1;
            }else{
                num = num +1;
            }
        }

        System.out.println("Suplos: " + suploja);
        System.out.println("Spragtels: " + spragteli);
    }
}
