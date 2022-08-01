package lt.bit.Figuros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String failoKelias = "JavaSestaSavaite/src/lt/bit/Figuros/duomenys.txt";
        List<Figura> figuros = skaityti(failoKelias);
        System.out.println(figuros);

        // surast figura turincia didziausia perimetra
        Figura didziausiasPerimetras = rastiDidziausiaPerimetra(figuros);
        System.out.println("Didziausias perimetras: "+didziausiasPerimetras);
        // surast figura kuri turi didziausia plota
        Figura didziausiasPlotas = rastiDidziausiaPlota(figuros);
        System.out.println("Didziausias plotas: "+didziausiasPlotas);
        // atspausdint kuriu figuru yra sarase daugiausia
        System.out.println("Daugiausia figuru yra: "+daugiausiaFiguru(figuros));
        //apsirasem ne itin teisingai,bet kaip pradinokams puse velnio

        Figura kvad = new Kvadratas(4);
        System.out.println("cia budas kaip priskirti metodui kokia tai reiksme: "+((Kvadratas)kvad).getClass()+" "+((Kvadratas)kvad).getX());// cia budas kaip priskirti metodui kokia tai reiksme
        Figura stac = new Staciakampis(5,6);
        System.out.println("cia budas kaip priskirti metodui kokia tai reiksme: "+((Staciakampis)stac).getClass()+" "+((Staciakampis)stac).getX()+" "+((Staciakampis)stac).getY());// cia budas kaip priskirti metodui kokia tai reiksme
    }

    public static List<Figura> skaityti(String failoKelias) {
        List<Figura> figuros = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(failoKelias));

            String eilute = br.readLine();
            int figuruKiekis = Integer.parseInt(eilute);

            for (int i = 0; i < figuruKiekis; i++) {
                eilute = br.readLine();
                String[] reiksmes = eilute.split(" ");
                if (reiksmes[0].equals("K")) {
                    double x = Double.parseDouble(reiksmes[1]);
                    Kvadratas kvadratas = new Kvadratas(x);
                    figuros.add(kvadratas);
                } else if (reiksmes[0].equals("S")) {
                    double x = Double.parseDouble(reiksmes[1]);
                    double y = Double.parseDouble(reiksmes[2]);
                    Staciakampis staciakampis = new Staciakampis(x, y);
                    figuros.add(staciakampis);
                } else if (reiksmes[0].equals("LT")) {
                    double x = Double.parseDouble(reiksmes[1]);
                    LygiakrastisTrikampis lygiakrastisTrikampis = new LygiakrastisTrikampis(x);
                    figuros.add(lygiakrastisTrikampis);
                } else if (reiksmes[0].equals("A")) {
                    double r = Double.parseDouble(reiksmes[1]);
                    Apskritimas apskritimas = new Apskritimas(r);
                    figuros.add(apskritimas);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return figuros;
    }

    public static Figura rastiDidziausiaPerimetra(List<Figura> figuros) {
        Figura maxPerim = null;
        if (figuros.size() > 0) {
            maxPerim = figuros.get(0);
        }
        for (int i = 1; i < figuros.size(); i++) {
            if (maxPerim.perimetras() < figuros.get(i).perimetras()) {
                maxPerim = figuros.get(i);
            }
        }
        return maxPerim;
    }
    public static Figura rastiDidziausiaPlota(List<Figura> figuros) {
        Figura maxPlotas = null;
        if (figuros.size() > 0) {
            maxPlotas = figuros.get(0);
        }
        for (int i = 1; i < figuros.size(); i++) {
            if (maxPlotas.plotas() < figuros.get(i).plotas()) {
                maxPlotas = figuros.get(i);
            }
        }
        return maxPlotas;
    }
    public static String daugiausiaFiguru(List<Figura> figuros){
        int kvadratuKiekis=0, apskritimuKiekis=0, trikampiuKiekis=0, staciakampiuKiekis=0;
        for (int i=0;i< figuros.size();i++){
            Figura figura = figuros.get(i);
            if(figura instanceof Kvadratas){
                kvadratuKiekis++;
            }else if (figura instanceof Apskritimas){
                apskritimuKiekis++;
            }else if (figura instanceof LygiakrastisTrikampis){
                trikampiuKiekis++;
            }else if (figura instanceof Staciakampis){
                staciakampiuKiekis++;
            }
        }
        if(kvadratuKiekis>apskritimuKiekis
        && kvadratuKiekis>trikampiuKiekis
        && kvadratuKiekis>staciakampiuKiekis){
            return "Kvadratu";
        }else if (apskritimuKiekis>kvadratuKiekis
        && apskritimuKiekis>trikampiuKiekis
        && apskritimuKiekis>staciakampiuKiekis){
            return "Apskritimu";
        }else if (trikampiuKiekis>kvadratuKiekis
        && trikampiuKiekis>apskritimuKiekis
        && trikampiuKiekis>staciakampiuKiekis){
            return "Lygiakrasciu Trikampiu";
        }else if (staciakampiuKiekis>kvadratuKiekis
        && staciakampiuKiekis>trikampiuKiekis
        && staciakampiuKiekis>apskritimuKiekis){
            return "Staciakampiu";
        }
        return "Figuru po lygiai";
    }

}
