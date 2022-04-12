package lt.bit;
//Parašiutininkas šoka iš h metrų aukščio. Vos iššokęs, iškart pradeda skleisti
//parašiutą, kuris iki galo išsiskleidžia per t sekundžių. Parašykite programą, kuri apskaičiuotų, ar
//parašiutas spės išsiskleisti prieš parašiutininkui pasiekiant žemę. Laikas, per kurį objektas
//nukrenta iš aukščio h randamas pagal formulę: t =
//g
//2h
//. Čia g - laisvojo kritimo pagreitis, kuris
//yra lygus 9.8 m/s2
//.

import java.util.Scanner;

public class Parasiutininkas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is kokio aukscio soka parasiutininkas (m.)?");
        double parasiutininkoAukstis = sc.nextDouble();
        System.out.println("Per kiek sekundziu issiskleidzia jo parasiutas?");
        double issiskleidimoLaikas = sc.nextDouble();
        //apskaiciuojam reiksme saknies viduje
        double sakniesVidus = 2*parasiutininkoAukstis/9.8;
        double parasiutininkasNukrisPer = Math.sqrt(sakniesVidus);
        if (parasiutininkasNukrisPer>issiskleidimoLaikas){
            System.out.println("Parasiutas issiskleis.");
        }else {
            System.out.println("Parasiutas neissiskleis.");
        }
    }

}
