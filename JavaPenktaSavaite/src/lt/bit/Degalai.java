package lt.bit;
//Šeima išsirengė į kelionę automobiliu. Jie pripildė kuro baką, kurio talpa t litrų ir
//nusprendė važiuoti tol, kol bake bus degalų. Lyginėmis kelionės dienomis automobilis suvartos n
//litrų degalų, o nelyginėmis - 2n litrų. Parašykite programą, kuri surastų, kiek dienų truks šeimos
//kelionė.

import java.util.Scanner;

public class Degalai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite kuro bako talpa: ");
        int t = in.nextInt();
        System.out.println("Iveskite kuro sanaudas n: ");
        int n = in.nextInt();
        int sunaudotaDegalu = 0;
        int maxKeliautosDienos = t / n;
        int nukeliautosDienos = 0;
        int i;
        for (i = 1; i <= maxKeliautosDienos; i++) {
            if (i % 2 == 0 && sunaudotaDegalu <= t) {
                sunaudotaDegalu = sunaudotaDegalu + n;
                nukeliautosDienos++;
            } else if (i % 2 == 1 && sunaudotaDegalu <= t) {
                sunaudotaDegalu = sunaudotaDegalu + 2 * n;
                nukeliautosDienos++;
            }
        }
        System.out.println("Keliauti bus galima: " + nukeliautosDienos+ " d.");
    }
}
