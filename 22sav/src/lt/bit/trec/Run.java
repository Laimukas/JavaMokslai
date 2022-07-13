package lt.bit.trec;

import java.util.ArrayList;
import java.util.List;

public class Run {
    //Sraigiu lenktynes:
    //
    //Sliauzia 10 sriagiu.
    //
    //Reikia nusliauzti 3 metrus.
    //Kiekviena sraige pasliauzia (random) 2-10 cm ir po to pamiega (random) 1-3 sekundes
    //Kas 50 cm sraige pasako (atspausdina i ekrana) savo pavadinima ir kiek ji nusliauze.
    //
    //Po to kai visos sraiges pabaige distancija,
    //reikia surusiuoti visas sraiges pagal distancijos iveikimo laika ir
    //atspausdinti turnyrine lentele.


    //destytojo Aliaus aprasytas / issprestas uzdavinys

    public static void main(String[] args) {
        List<Sraige> dalyviai = new ArrayList();
        // startuojam visus dalyvius
        for (int i = 1; i <= 10; i++) {
            Sraige s = new Sraige("" + i);
            s.start();
            dalyviai.add(s);
        }
        // laukiam, kol visi pabaigs trasa
        for (Sraige sraige : dalyviai) {
            try {
                sraige.join();
            } catch (InterruptedException ex) {
                // ignore
            }
        }
        // surusiuojam pagal trasos iveikimo laika
        dalyviai.sort((s1, s2) -> (int) (s1.getLaikas() - s2.getLaikas()));
        System.out.println("varzybos pasibaige");
        System.out.println("turnyrine lentele:");
        for (int i = 0; i < dalyviai.size(); i++) {
            Sraige s = dalyviai.get(i);
            System.out.println((i + 1) + " - " + s);
        }
    }
}
