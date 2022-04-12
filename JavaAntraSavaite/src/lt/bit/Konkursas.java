package lt.bit;
//Restorano ,,Skanu" vadybininkas sugalvojo surengti konkursą lankytojams, kurio
//metu galima laimėti marškinėlius su restorano logotipu. Visi lankytojai kartu su sąskaita gauna
//po vieną kortelę, ant kurios parašytas sveikasis teigiamas skaičius iš intervalo [a;b] (a –
//intervalo pradžia, b – intervalo pabaiga). Laimi tie lankytojai, kurių kortelėse įrašytas skaičius
//dalijasi iš 6. Parašykite programą, kuri apskaičiuotų, kiek marškinėlių reikia užsakyti restorano
//vadybininkui.

import java.util.Scanner;

public class Konkursas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Intervalo pradzia");
        int min = in.nextInt();
        System.out.println("Intervalo pabaiga");
        int max = in.nextInt();
        int size = max - min;
        int counter = 0;
        int num = min;

        for (int i = 0; i < size + 1; i++) {

            if (num % 6 == 0) {
                num = num + 1;
                counter = counter + 1;
                // System.out.println("Skaiciuojam counter: " + counter);
            } else {
                num = num + 1;
            }
            //System.out.println("Skirtumas : "+num);
        }
        System.out.println("Reiks marskineliu: " + counter);
    }
}

