package lt.bit;
//Varžybose dalyvauja n bėgikų. Pirmasis bėgikas įveikė distanciją per k1
//sekundžių, antrasis – per k2, ..., n-tasis – per kn. Parašykite programą, surandančią, kuris bėgikas
//įveikė distanciją greičiausiai (išspausdinti bėgiko laiką) ir keliomis sekundėmis jis buvo
//greitesnis už vidutiniškai bėgusį bėgiką.

import java.util.Scanner;

public class BegimoVarzybos {
    public static void main(String[] args) {
        double laikuSuma=0;
        double greiciausiasLaikas=99999;
         Scanner scanner=new Scanner(System.in);
        System.out.println("Kiek dalyvavo begiku: ");
        int begikuKiekis = scanner.nextInt();
        for (int i=1;i<=begikuKiekis;i++){
            System.out.println("Iveskite "+i+" begiko laika: ");
            double begikoLaikas = scanner.nextDouble();
            if (begikoLaikas<greiciausiasLaikas){
                greiciausiasLaikas=begikoLaikas;
                laikuSuma=laikuSuma+begikoLaikas;
            }else{
                laikuSuma=laikuSuma+begikoLaikas;
            }

        }
        double laikuVidurkis = laikuSuma/begikuKiekis;
        double greitesnisUzVidurki=1.0*(laikuVidurkis-greiciausiasLaikas);
        System.out.println("Greiciausio begiko laikas: "+greiciausiasLaikas+" sek.");
        System.out.println("Jis buvo "+greitesnisUzVidurki+" sek. greitesnis uz vidurki.");
    }

}
