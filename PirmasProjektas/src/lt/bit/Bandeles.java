package lt.bit;
//Julius, grįžęs iš mokyklos namo, rado tokį mamos raštelį:
//Nueik į parduotuvę ir nupirk bandelių su varške.
//Jei viena bandelė kainuos ne daugiau kaip a Lt, nupirk n1 bandelių;
//Jei daugiau nei a, bet mažiau nei b, nupirk n2 bandelių;
//O jei kainuos b arba daugiau, negu b - n3 bandelių.
//Nuėjęs į parduotuvę, Julius pamatė, kad bandelė kainuoja k Lt.
//Parašykite programą, kuri apskaičiuotų, kiek pinigų už bandeles sumokės Julius.
//(a visada mažiau nei b).

import java.util.Scanner;

public class Bandeles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite kainas. Kaina a < Kaina b !!!");
        System.out.println("Kaina a ->");
        double kainaA = sc.nextDouble();
        System.out.println("Kaina b ->");
        double kainaB = sc.nextDouble();
        System.out.println("Iveskite bandeliu kiekius: n1,n2,n3");
        System.out.println("n1 ->");
        double n1 = sc.nextDouble();
        System.out.println("n2 ->");
        double n2 = sc.nextDouble();
        System.out.println("n3 ->");
        double n3 = sc.nextDouble();
        System.out.println("Iveskite bandeles kaina.");
        double bandelesKaina = sc.nextDouble();
        //apsirasau kiek kainuos bandeliu ivairiais varijantais
        double visoKainuos1 = bandelesKaina*n1;
        double visoKainuos2 = bandelesKaina*n2;
        double visoKainuos3 = bandelesKaina*n3;
        if (bandelesKaina<kainaA){
            System.out.println("Uz bandeles bus sumoketa: " +visoKainuos1+" Lt.");
        }else if (bandelesKaina>=kainaA && bandelesKaina<kainaB){
            System.out.println("Uz bandeles bus sumoketa: " +visoKainuos2+" Lt.");
        }else{
            System.out.println("Uz bandeles bus sumoketa: " +visoKainuos3+" Lt.");
        }


    }
}
