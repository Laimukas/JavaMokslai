package lt.bit;
//Tadas mėgsta skaityti knygas, tačiau jam labai sunku pradėti skaityti. Knygoje yra m
//skyrių Pirmą dieną Tadas perskaitė 1 skyrių, antrą – 2, trečią – 3 ir t.t. Kiekvieną kitą dieną jis
//perskaito vienu skyriumi daugiau, negu prieš tai buvusią dieną. Programa turi apskaičiuoti, per
//kelias dienas d Tadas perskaitys visą knygą ir kelis skyrius s vidutiniškai per dieną perskaito
//Tadas. Paskutinei dienai gali likti mažiau skyrių.

import java.util.Scanner;

public class Knyga {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite knygos skyriu skaiciu: ");
        double m = in.nextDouble();
        int d=0; //per kiek dienu perskaitys knyga
        double s=0; //vidutinis skyriu kiekis per diena
        int skyriuSuma=0;
        for (int i =1;i<=m;i++){
            if (skyriuSuma<=m){
                skyriuSuma=skyriuSuma+i;
                d++;
            }else{

                s= (m/d);
            }
        }
        System.out.println("Tadas visa knyga perskaitys per "+d+" dienas (-u).");
        System.out.println("Tadas vidutiniskai per diena perskaite "+s+" skyrius (-u).");
    }
}
