package lt.bit.antr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    //Sraigiu lenktynes:
    //
    //Sliauzia 10 sriagiu.  DONE
    //
    //Reikia nusliauzti 3 metrus.  DONE
    //Kiekviena sraige pasliauzia (random) 2-10 cm ir po to pamiega (random) 1-3 sekundes
    //Kas 50 cm sraige pasako (atspausdina i ekrana) savo pavadinima ir kiek ji nusliauze.
    //
    //Po to kai visos sraiges pabaige distancija,
    //reikia surusiuoti visas sraiges pagal distancijos iveikimo laika ir
    //atspausdinti turnyrine lentele.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Ivesk nuo: ");
//        int nuo = sc.nextInt();
        System.out.println("Ivesk distancijos ilgi : ");
        int iki = sc.nextInt();
        System.out.println("Kiek sraigiu: ");
        int kiekis = sc.nextInt();

        List<Sraige> sraiges = new ArrayList();

        int kiek = 1;

        while (kiek <= kiekis) {
            Sraige t = new Sraige(0, iki,String.valueOf(kiek+" sraige"));
            t.start();
            sraiges.add(t);
            kiek++;
        }

    }
}
