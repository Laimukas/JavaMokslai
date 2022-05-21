package lt.bit.SkaniausiSaldainiai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String failoKelias = "JavaSeptintaSavaite/src/lt/bit/SkaniausiSaldainiai/duomenys.txt";

        List<Gamintojas> gamintojai = skaityti(failoKelias);
        System.out.println("pries rikiavima");
        System.out.println(gamintojai);

        rikiuotiSaldainius(gamintojai);
        System.out.println("po rikiavimo");
        System.out.println(gamintojai);

        //atspausdinti i konsole kad atrodytu kaip uzduoties rezultatai

        //atspausdinti i faila kad atrodytu kaip uzduoties rezultatai

    }

    public static List<Gamintojas> skaityti(String failoKelias) {
        List<Gamintojas> gamintojai = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(failoKelias));
            String eilute = br.readLine();
            int gamintojuKiekis = Integer.parseInt(eilute);
            System.out.println("gamintoju kiekis: " + gamintojuKiekis);

            for (int i = 0; i < gamintojuKiekis; i++) {
                eilute = br.readLine();
                String gamintojoPavadinimas = eilute.substring(0, 24).trim();
                int saldiniuKiekis = Integer.parseInt(eilute.substring(25));
                List<Saldainis> saldainiai = new ArrayList<>();
                Gamintojas gamintojas = new Gamintojas(gamintojoPavadinimas, saldainiai);
                for (int j = 0; j < saldiniuKiekis; j++) {
                    eilute = br.readLine();
                    String saldainioPavadinimas = eilute.substring(0, 19).trim();
                    int ivertinimas = Integer.parseInt(eilute.substring(20));  //pasiimam ivertinima esanti 20 eilutes pozicijoj
                    Saldainis saldainis = new Saldainis(saldainioPavadinimas, ivertinimas);
                    saldainiai.add(saldainis);
                }
                gamintojai.add(gamintojas);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gamintojai;
    }

    public static void rikiuotiSaldainius(List<Gamintojas> gamintojai){
        for (int i =0;i< gamintojai.size();i++){
            Collections.sort(gamintojai.get(i).getSaldainiai());
        }
    }

}
