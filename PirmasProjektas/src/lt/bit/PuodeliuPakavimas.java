package lt.bit;
//Į vieną kartoninę dėžutę telpa trys puodeliai. Pakuotojas užklijuoja
//dėžutę ir išsiunčia ją į parduotuvę, jei ji pilna. Iš viso reikia supakuoti m puodelių. Parašykite
//programą, kuri apskaičiuotų, kelios bus pilnos dėžutės ir kiek puodelių liks nesupakuota.


import java.util.Scanner;

public class PuodeliuPakavimas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Puodeliu, kuriuos reikia supakuoti, skaicius, yra: (iveskite skaiciu)");
        double puodeliuSkaicius = sc.nextDouble();
        double pakuociuSkaicius = puodeliuSkaicius/3;
        int lyginesPakuotes = (int)pakuociuSkaicius;
        double liksPuodeliu = puodeliuSkaicius - lyginesPakuotes*3;
        int liksLyginisPuodeliu = (int)liksPuodeliu;

        if (pakuociuSkaicius == (int) pakuociuSkaicius) {
            //tikrinam ar gaunasi dalyboje lyginis ar nelyginis skaicius
            //siuo atveju skaicius turi buti lyginis,seka ir atitinkamas atsakymas
            System.out.println("Pakuociu skaicius bus " +lyginesPakuotes+
                    ". Likusiu puodeliu nebus.");
        } else {

            System.out.println("Pakuociu skaicius bus " +lyginesPakuotes+
                    ", o puodeliu liks " + liksLyginisPuodeliu);
        }
    }
}
