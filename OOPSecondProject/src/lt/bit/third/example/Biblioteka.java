package lt.bit.third.example;


import java.util.ArrayList;
import java.util.Collections;

public class Biblioteka {


    private ArrayList<Knyga> knygos;

    public Biblioteka(ArrayList<Knyga> knygos) {

        this.knygos = knygos;
    }
    // uzduoties 1 punktas -- visu pasirinkto autoriaus knygu kiekio ir vidutinio puslapiu skaiciaus skaiciavimas

    public void getKnyguKiekisIrVidPuslapiuSkaicius(String autorius) {
        int knyguCounter = 0;
        int puslapiuSkaicius = 0;
        for (Knyga knyga : knygos) {
            if (knyga.getAutorius().equals(autorius)) {
                knyguCounter++;
                puslapiuSkaicius += knyga.getPuslapiuSkaicius();

            }
        }
        System.out.println("Uzduoties 1 punktas");
        System.out.println("Knygu skaicius autoriaus: " + autorius + " yra: " + knyguCounter);
        int vidPuslapiuSkaicius = puslapiuSkaicius / knyguCounter;
        System.out.println("Vidutinis puslapiu skaicius knygoje yra: " + vidPuslapiuSkaicius);

    }

    // uzduoties 2 punktas -- paieska pagal knygos autoriu ir knygos koda

    public void paieskaPagalAutoriausIrKnygosKoda(String autorius, String knygosKodas) {
        System.out.println("Uzduoties 2 punktas");
        for (Knyga knyga : knygos) {
            if (paieska(knyga, autorius, knygosKodas)) {
                System.out.println("Knygos informacija: " + knyga);
            }
        }
    }

    private boolean paieska(Knyga knyga, String autorius, String knygosKodas) {
        return knyga.getAutorius().equals(autorius) && knyga.getKnygosKodas().equals(knygosKodas);
    }

    // uzduoties 3 punktas -- paieska pagal knygos autoriu,knygos koda,leidykla ir leidimo metus

    public void paieska(String autorius, String knygosKodas, String leidykla, int leidimoMetai) {
        System.out.println("Uzduoties 3 punktas");
        knygos.forEach(knyga -> {
            if (paieska(knyga, autorius, knygosKodas) && knyga.getLeidykla().equals(leidykla)
                    && knyga.getLeidimoMetai() == leidimoMetai) {
                System.out.println(knyga);
            }
        });
        // kitas varijantas
//        for (Knyga knyga : knygos) {
//            if (paieska(knyga, autorius, knygosKodas) && knyga.getLeidykla().equals(leidykla)
//                    && knyga.getLeidimoMetai() == leidimoMetai) {
//                System.out.println(knyga);
//            }
//        }
    }
    // uzduoties 4 punktas -- pasirinktos leidyklos knygu saraso rikiavimas pagal autoriu ir leidimo metus

    public void knyguSarasoRikiavimasPagalPasirinktaLeidykla(String leidykla) {
        System.out.println("Uzduoties 4 punktas");
        ArrayList<Knyga> pasirinktosLeidyklosKnygos = new ArrayList<>();

        for (Knyga knyga : knygos) {
            if (knyga.getLeidykla().equals(leidykla)) {
                pasirinktosLeidyklosKnygos.add(knyga);
            }
        }
        //     Collections.sort(pasirinktosLeidyklosKnygos,((o1, o2) -> Integer.compare(o1.getLeidimoMetai(),o2.getLeidimoMetai())));

        Collections.sort(knygos, new AutoriuRikiavimas());
        Collections.sort(knygos, new RikiavimasPagalLeidimoMetus());

        pasirinktosLeidyklosKnygos.forEach(knyga -> System.out.println(knyga));


    }
}
