package lt.bit.SkaniausiSaldainiai;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String failoKelias = "JavaSeptintaSavaite/src/lt/bit/SkaniausiSaldainiai/duomenys.txt";
        String rezultatuFailoKelias = "JavaSeptintaSavaite/src/lt/bit/SkaniausiSaldainiai/rezultatai.txt";
        List<Gamintojas> gamintojai = skaityti(failoKelias);

        rikiuotiSaldainius(gamintojai);

        //atspausdinti i konsole kad atrodytu kaip uzduoties rezultatai
        spausdintiGamintojus(gamintojai);

        //atspausdinti i faila kad atrodytu kaip uzduoties rezultatai
        spausdintiGamintojus(rezultatuFailoKelias, gamintojai);
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

    public static void spausdintiGamintojus(List<Gamintojas> gamintojai){
        for (int i =0;i< gamintojai.size();i++){
            Gamintojas gamintojas = gamintojai.get(i);
            System.out.println(gamintojai.get(i).getPavadinimas());
            for (int j =0;j<gamintojas.getSaldainiai().size();j++){
                Saldainis saldainis= gamintojas.getSaldainiai().get(j);
                System.out.println(String.format("%-25s",saldainis.getPavadinimas())+saldainis.getIvertinimas());
            }
        }
    }

    public static void spausdintiGamintojus(String failoKelias, List<Gamintojas> gamintojai){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(failoKelias));
            for (int i =0;i< gamintojai.size();i++){
                Gamintojas gamintojas = gamintojai.get(i);
                bw.write(gamintojai.get(i).getPavadinimas()+"\n");
              //  bw.newLine();  cia vietoj +"\n"
                for (int j =0;j<gamintojas.getSaldainiai().size();j++){
                    Saldainis saldainis= gamintojas.getSaldainiai().get(j);
                    bw.write(String.format("%-25s",saldainis.getPavadinimas())+saldainis.getIvertinimas()+"\n");
              //      bw.newLine();  cia vietoj +"\n"
                }
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
