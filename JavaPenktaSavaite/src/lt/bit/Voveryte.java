package lt.bit;


import java.util.Scanner;

public class Voveryte {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Sukauptas riesutu kiekis X = ");
        int x = in.nextInt();
        System.out.println("Voveriuku skaicius V = ");
        int v = in.nextInt();
        int suvalgysPerDiena = 3*(1+v);
        int keliomsDienomsUzteksRiesutu = x/suvalgysPerDiena;
        if (keliomsDienomsUzteksRiesutu>=92){
            System.out.println("Riesutu sukaupta "+keliomsDienomsUzteksRiesutu+" dienoms.");
            System.out.println("Riesutu uzteks visai ziemai");
        }else{
            System.out.println("Riesutu sukaupta "+keliomsDienomsUzteksRiesutu+" dienoms.");
            System.out.println("Riesutu neuzteks visai ziemai");
        }
    }
}
