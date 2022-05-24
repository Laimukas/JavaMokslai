package lt.bit.IdomiausiFilmai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //nurodome duomenu failo kelia
        String duomenuFailoKelias = "JavaAstuntaSavaite/src/lt/bit/IdomiausiFilmai/duomenys.txt";
        //iskvieciam nuskaitymo metoda
        List<Filmas> filmai = skaityti(duomenuFailoKelias);
        System.out.println(filmai);
        //surikiuot filmus

        //atspausdinti i faila
    }
    public static List<Filmas> skaityti(String duomenuFailoKelias){
        List<Filmas> filmai = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(duomenuFailoKelias))){
            String eilute = br.readLine();
            int filmuKiekis = Integer.parseInt(eilute);
            System.out.println("filmu kiekis: " + filmuKiekis);

            for (int i = 0; i < filmuKiekis; i++) {
                eilute = br.readLine();
                String[] reiksmes = eilute.split(" ");

                int metai = Integer.parseInt(reiksmes[0]);
                String filmoPavadinimas = eilute.substring(5, 29).trim();
                LocalTime trukme = LocalTime.of(Integer.parseInt(reiksmes[reiksmes.length-3]),Integer.parseInt(reiksmes[reiksmes.length-2]));
                int ziurovuKiekis = Integer.parseInt(reiksmes[reiksmes.length-1]);

                Filmas filmas = new Filmas(filmoPavadinimas,metai,trukme,ziurovuKiekis);

                filmai.add(filmas);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return filmai;
    }
    public static void rikiuotiFilmus(List<Filmas> filmai){
        for (int i =0;i< filmai.size();i++){
            //kaip juos surikiuot :(
       //   Collections.sort(filmai.get(i).getZiurovuSkaiciusMln(),Collections.sort(filmai.get(i).getMetai()));
        }
    }
}
