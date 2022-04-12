package lt.bit;
//Didžioji kūdrinė varlė – beuodegis varliagyvis. Ji sveria m gramų (m -
//realusis skaičius). Mokslininkai, tyrinėjantys didžiąsias kūdrines varles, nusprendė n varlių
//stebėti. Jei stebimos varlės svers daugiau kaip 5 kilogramus, ekrane turi būti rodomas pranešimas
//,,Varlių stebėjimui pakanka“, jei mažiau – ,,Varlių stebėjimui per mažai“.

import java.util.Scanner;

public class DidzKudrineVarle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek sveria varle?");
        double varlesSvoris = sc.nextDouble();
        System.out.println("Kiek varliu norim stebeti?");
        double norimuStebetiVarliuKiekis = sc.nextDouble();
        // apskaiciuojam visu varliu svori
        double visosVarlesSvers = varlesSvoris*norimuStebetiVarliuKiekis;
        if (visosVarlesSvers>5000){
            System.out.println("Varliu stebejimui pakanka.");
        }else{
            System.out.println("Varliu stebejimui per mazai");
        }
    }
}

