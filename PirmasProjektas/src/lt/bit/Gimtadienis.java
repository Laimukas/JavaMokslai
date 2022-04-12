package lt.bit;
//Tautvydas rengia gimtadienio šventę. Norėdamas pavaišinti svečius, jis iškepė
//a sausainių. Prasidėjus šventei, jis pastebėjo, kad dar b draugų iškepė lygiai tiek pat sausainių
//kaip ir jis, ir atsinešė į gimtadienį. Šventėje iš viso dalyvavo c žmonių (įskaitant ir patį
//jubiliatą). Norėdamas, kad nei vienas neliktų nuskriaustas, Tautvydas sausainius visiems
//svečiams padalijo po lygiai ir, kadangi šiandien jo gimtadienis, likusius po dalybų nusprendė
//pasilikti sau. Parašykite programą, kuri apskaičiuotų, po kiek sausainių gavo kiekvienas
//gimtadienio dalyvis ir kiek papildomai sausainių atiteko Tautvydui.

import java.util.Scanner;

public class Gimtadienis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek sausainiu iskepe Tautvydas?");
        double sausainiuIskepeTautvydas = sc.nextDouble();
        System.out.println("Keli draugai dar atsinese po tiek pat sausainiu?");
        double draugaiAtsineseSausainiu = sc.nextDouble();
        System.out.println("Kiek zmoniu is viso dalyvavo sventeje?");
        double visoDalyviuSkaicius = sc.nextDouble();
        double visoSausainiu = sausainiuIskepeTautvydas + draugaiAtsineseSausainiu*sausainiuIskepeTautvydas;
        double kiekvienasGavoPoSausainiu = visoSausainiu/visoDalyviuSkaicius;
        //apsirasau jog kiekvienas turetu gauti po lygini sausainiu kieki
        int lyginiaiSausainiai = (int) kiekvienasGavoPoSausainiu;
        //apsirasau kiek sausainiu liks
        double liksSausainiu = visoSausainiu - visoDalyviuSkaicius * lyginiaiSausainiai;
        int liksSausainiuTautvydui = (int) liksSausainiu;

        if (kiekvienasGavoPoSausainiu == (int) kiekvienasGavoPoSausainiu) {
            //tikrinam ar gaunasi dalyboje lyginis ar nelyginis skaicius
            //siuo atveju skaicius turi buti lyginis,seka ir atitinkamas atsakymas
            System.out.println("Kiekvienas sventes dalyvis gavo po " +lyginiaiSausainiai+ " sausainius. Tautvydui papildomai sausainiu gauti neteko.");
        } else if (liksSausainiuTautvydui == 1){
            System.out.println("Kiekvienas sventes dalyvis gavo po " +lyginiaiSausainiai+ " sausainius. Tautvydas papildomai gavo viena sausaini.");
        } else{
            System.out.println("Kiekvienas sventes dalyvis gavo po " +lyginiaiSausainiai+ " sausainius. Tautvydas papildomai gavo "
                    +liksSausainiuTautvydui+ " sausainius.");
        }

    }
}
