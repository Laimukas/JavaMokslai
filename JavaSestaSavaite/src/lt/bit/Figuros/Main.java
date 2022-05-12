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

        // surast figura kuri turi didziausia plota

        // atspausdint kuriu figuru yra sarase daugiausia

    }
    public static List<Figura> skaityti (String failoKelias){
        List<Figura> figuros = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(failoKelias));

            String eilute = br.readLine();
            int figuruKiekis = Integer.parseInt(eilute);

            for (int i =0;i<figuruKiekis;i++){
                eilute= br.readLine();
                String[] reiksmes=eilute.split(" ");
                if(reiksmes[0].equals("K")){
                    double x = Double.parseDouble(reiksmes[1]);
                    Kvadratas kvadratas = new Kvadratas(x);
                    figuros.add(kvadratas);
                }else if(reiksmes[0].equals("S")){
                    double x = Double.parseDouble(reiksmes[1]);
                    double y = Double.parseDouble(reiksmes[2]);
                    Staciakampis staciakampis = new Staciakampis(x,y);
                    figuros.add(staciakampis);
                }else if(reiksmes[0].equals("LT")){
                    double x = Double.parseDouble(reiksmes[1]);
                    LygiakrastisTrikampis lygiakrastisTrikampis=new LygiakrastisTrikampis(x);
                    figuros.add(lygiakrastisTrikampis);
                }else if(reiksmes[0].equals("A")){
                    double r = Double.parseDouble(reiksmes[1]);
                    Apskritimas apskritimas=new Apskritimas(r);
                    figuros.add(apskritimas);
                }
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return figuros;
    }

}
