package lt.bit;
//Marius kiekvieną dieną gauna po n saldainių. Jis suvalgo po a
//saldainių, o likusius kaupia Kalėdų dovanoms. Kai Marius pradėjo kaupti saldainius, iki Kalėdų
//buvo likę k dienų. Parašykite programą, kuri suskaičiuotų keliems draugams d Marius galės
//paruošti kalėdinius saldainių rinkinius, jei kiekviename rinkinyje bus po a saldainių ir kiek
//saldainių s liks supakavus dovanas.

import java.util.Scanner;

public class MariausSaldainiai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek saldainiu gauna Marius?");
        double saldainiuGaunaMariusKasdien = sc.nextDouble();
        System.out.println("Po kiek saldainiu suvalgo?");
        double suvalgoKasdien = sc.nextDouble();
        System.out.println("Kiek dienu liko iki Kaledu?");
        double dienosIkiKaledu = sc.nextDouble();
        //prilyginu jog pakuotese bus tiek pat saldainiu kiek ir Marius gauna ju kasdien
        double kiekisSaldainiuRinkiniuose = suvalgoKasdien;
        //apskaiciuoju kiek saldainiu bus sukaupta iki Kaledu
        double saldainiuSukauptaIkiKaledu = dienosIkiKaledu*(saldainiuGaunaMariusKasdien-suvalgoKasdien);
        //apskaiciuoju kiek gausis pakuociu (keliems draugams) su saldainiais
        double keliDraugaiGausDovanas = saldainiuSukauptaIkiKaledu/kiekisSaldainiuRinkiniuose;
        //apsirasau jog draugu kiekis turi buti lyginis :)
        int lyginiaiDraugai = (int) keliDraugaiGausDovanas;
        //reik apskaiciuot kiek liks saldainiu Mariui po dalybu
        double liksSaldainiuMariui = saldainiuSukauptaIkiKaledu - lyginiaiDraugai*kiekisSaldainiuRinkiniuose;
        //del viso pikto keiciu Double i Int, grazesniam atsakymui
        int lygSaldKiekisMariui = (int) liksSaldainiuMariui;
        //apsirasom dabar salygas ir atsakymus
        if (keliDraugaiGausDovanas == (int) keliDraugaiGausDovanas) {
            //tikrinam ar gaunasi dalyboje lyginis ar nelyginis skaicius
            //siuo atveju skaicius turi buti lyginis,seka ir atitinkamas atsakymas
            System.out.println("Is Mariaus dovanas gaus " +lyginiaiDraugai+ " draugu. Supakavus dovanas Mariui saldainiu neliko.");
        } else if (lygSaldKiekisMariui == 1){ //cia tiesiog apsirasymas jei gautusi jog Mariui liko 1 saldainis po dalybu
            System.out.println("Is Mariaus dovanas gaus " +lyginiaiDraugai+ " draugu. Supakavus dovanas Mariui liko vienas saldainis.");
        } else{
            System.out.println("Is Mariaus dovanas gaus " +lyginiaiDraugai+ " draugu. Supakavus dovanas Mariui liko "+lygSaldKiekisMariui+ " saldainiai.");
        }

    }
}
