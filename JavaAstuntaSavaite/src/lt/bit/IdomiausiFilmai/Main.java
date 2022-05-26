package lt.bit.IdomiausiFilmai;

import javax.naming.directory.SearchResult;
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //nurodome duomenu failo kelia
        String duomenuFailoKelias = "JavaAstuntaSavaite/src/lt/bit/IdomiausiFilmai/duomenys.txt";
        String rezultatuFailoKelias = "JavaAstuntaSavaite/src/lt/bit/IdomiausiFilmai/rezultatai.txt";
        //iskvieciam nuskaitymo metoda
        List<Filmas> filmai = skaityti(duomenuFailoKelias);
        System.out.println(filmai);
        //surikiuot filmus
        Collections.sort(filmai);
        System.out.println(filmai);
        //atspausdinti i faila
        irasytiFilmusFailan(rezultatuFailoKelias,filmai);

        //surikiuoti naudojant anonimine klase
        //pagal pavadinima,jei lygu pagal metus,jei lygu pagal ziurovuSkaiciusMln
        Collections.sort(filmai, new Comparator<Filmas>() {
            @Override
            public int compare(final Filmas o1,final Filmas o2) {
                int res = o1.getPavadinimas().compareToIgnoreCase(o2.getPavadinimas());
                if (res != 0) {
                    return res;
                }
            return o1.getZiurovuSkaiciusMln().compareTo(o2.getZiurovuSkaiciusMln());
            }
        });
        System.out.println(filmai);
    }

    public static List<Filmas> skaityti(String duomenuFailoKelias) {
        List<Filmas> filmai = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(duomenuFailoKelias))) {
            String eilute = br.readLine();
            int filmuKiekis = Integer.parseInt(eilute);
            System.out.println("filmu kiekis: " + filmuKiekis);

            for (int i = 0; i < filmuKiekis; i++) {
                eilute = br.readLine();
                String[] reiksmes = eilute.split(" ");

                int metai = Integer.parseInt(reiksmes[0]);
                String filmoPavadinimas = eilute.substring(5, 29).trim();
                int valandos = Integer.parseInt(reiksmes[reiksmes.length - 3]);
                int minutes = Integer.parseInt(reiksmes[reiksmes.length - 2]);
                LocalTime trukme = LocalTime.of(valandos, minutes);
                Integer ziurovuKiekis = Integer.parseInt(reiksmes[reiksmes.length - 1]);

                Filmas filmas = new Filmas(filmoPavadinimas, metai, trukme, ziurovuKiekis);

                filmai.add(filmas);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filmai;
    }
    //Rikiavimas
//    Collections.sort(rowItems,new Comparator<SearchResult>){
//        @Override
//                public static compare(final SearchResult o1, final SearchResult o2){
//            LocalTime compare = o1.
//        }
//    }
    public static void irasytiFilmusFailan(String failoKelias, List<Filmas> filmai){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(failoKelias));
            for (int i =0;i< filmai.size();i++){
                Filmas filmas = filmai.get(i);

                bw.write(String.format("%s %-29s %s %s",filmai.get(i).getMetai(),filmai.get(i).getPavadinimas(),"trukmė: "+filmai.get(i).getTrukme(),"; susirinko žiūrovų: "+filmai.get(i).getZiurovuSkaiciusMln()+" Mln."));
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
