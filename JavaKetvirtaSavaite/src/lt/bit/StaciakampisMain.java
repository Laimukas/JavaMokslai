package lt.bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StaciakampisMain {
    // Susikurti klase Staciakampis su laukais id, x ir y.DONE
    // Nuskaityti faila ir issaugoti juos Staciakampis[].DONE
    // Rasti didziausia perimetra turincia figura.
    // didziausia plota turincias figuras.

    public static void main(String[] args) {
        Staciakampis[] staciakampiai = skaitom("JavaKetvirtaSavaite/src/lt/bit/staciakampiai.txt");
        System.out.println(Arrays.toString(staciakampiai));

        Staciakampis maxPer = didziausiasPerimetras(staciakampiai);
        System.out.println("Didziausias perimetras= "+maxPer);

        Staciakampis maxPlotas = didziausiasPlotas(staciakampiai);
        System.out.println("Didziausias plotas="+maxPlotas);
    }

    public static Staciakampis[] skaitom(String failoKelias) {
        Staciakampis[] laikinas = null;


        try {
            BufferedReader br = new BufferedReader(new FileReader(failoKelias));
            String eilute0 = br.readLine();
            // System.out.println(eilute0);
            int eiluciuKiekis = Integer.parseInt(eilute0);
            laikinas = new Staciakampis[eiluciuKiekis];
            for (int i = 0; i < eiluciuKiekis; i++) {
                eilute0 = br.readLine();
                String[] reiksmes = eilute0.split(" ");
                // System.out.println(Arrays.toString(reiksmes));
                String id = reiksmes[0];
                double x = Double.parseDouble(reiksmes[1]);
                double y = Double.parseDouble(reiksmes[2]);
                Staciakampis s = new Staciakampis(id, x, y);
                laikinas[i] = s;
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return laikinas;
    }

    public static Staciakampis didziausiasPerimetras(Staciakampis[] figuros) {
        Staciakampis maxPerimetras = null;
        if (figuros.length > 0) {
            maxPerimetras = figuros[0];
        }
        for (int i = 1; i < figuros.length; i++) {
            if (maxPerimetras.perimetras() < figuros[i].perimetras()) {
                maxPerimetras = figuros[i];
            }
        }
        return maxPerimetras;
    }

    public static Staciakampis didziausiasPlotas(Staciakampis[] figuros) {
        Staciakampis maxPlotas = null;
        if (figuros.length > 0) {
            maxPlotas = figuros[0];
        }
        for (int i = 1; i < figuros.length; i++) {
            if (maxPlotas.plotas() < figuros[i].plotas()) {
                maxPlotas = figuros[i];
            }
        }
        return maxPlotas;
    }
}
