package LaboratorinisDarbasNR2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FailoNuskaitytuvas {

    private String kontentas;

    private final List<Character> balses = List.of('a', 'i', 'u', 'e');

    public FailoNuskaitytuvas(File failasKuriNuskaityti) throws IOException {
        kontentas = FileUtils.readFileToString(failasKuriNuskaityti, StandardCharsets.UTF_8);
    }

    public void nuskaitytiZodziais() {
        isskirti(" ");
    }

    public void nuskaitytiSakinius(){
        String senasKontentas = kontentas;
        kontentas = kontentas.replaceAll("[\\r\\n]+"," ");
        isskirti("\\.");
        kontentas = senasKontentas;
    }

    public void nuskaitytiEilutes(){
        isskirti("\\n");
    }

    private void isskirti(String pagalKaSplitinti){
        String[] zodziai = kontentas.split(pagalKaSplitinti);

        for (String zodis : zodziai) {
            System.out.println(zodis);
        }
    }

    public void nustatytiKiekEiluciuIrKoksKiekvienosEilutesIlgis(){
        String[] eilutes = kontentas.split("\\n");
        System.out.println("Eiluciu skaicius: " + eilutes.length);

        for (String eilute : eilutes) {
            System.out.println("-----");
            System.out.println(eilute);
            System.out.println("Eilutes ilgis: " + eilute.length());
            System.out.println("-----");
        }
    }

    public void surastiIlgiausiaZodi(){
        System.out.println("Ilgiausias zodis yra: " + rastiIlgiausiaZodi(kontentas));
    }

    public void rastiIlgiausiaZodiSakinyje(String sakinys){
        System.out.println("Ilgiausias zodis yra: " + rastiIlgiausiaZodi(sakinys));
    }

    private String rastiIlgiausiaZodi(String tekstas) {
        String[] zodziai = tekstas.split(" ");

        int ilgiausioZodzioIlgis = 0;
        String ilgiausiasZodis = null;

        for(String zodis : zodziai){
            if(ilgiausioZodzioIlgis < zodis.length()){
                ilgiausioZodzioIlgis = zodis.length();
                ilgiausiasZodis = zodis;
            }
        }

        return ilgiausiasZodis;
    }

    public void pasalintiIlgiausiaZodiKiekvienojeEiluteje(){
        String[] eilutes = kontentas.split("//n");
        ArrayList<String> naujosEilutes = new ArrayList<>();

        for(String eilute : eilutes){
            String ilgiausiasZodis = rastiIlgiausiaZodi(eilute);
            int ilgiausioZodzioIndeksas = eilute.indexOf(ilgiausiasZodis);
            naujosEilutes.add(eilute.substring(0, ilgiausioZodzioIndeksas).concat(eilute.substring(ilgiausioZodzioIndeksas + 1)));
        }

        naujosEilutes.forEach(eilute -> System.out.println(eilute));
    }

    public void surastiKiekYraMazujuLotiniskuRaidziu(){
        String[] eilutes = kontentas.split("\\n");

        for(String eilute: eilutes){
            int raidziuSkaicius = 0;
            String[] zodziai = eilute.split(" ");

            for(String zodis : zodziai){
                char[] raides = zodis.toCharArray();

                for(char raide : raides){
                    if(raide >= 'a' && raide <= 'z'){
                        raidziuSkaicius++;
                    }
                }
            }

            System.out.println("Eilute : " + eilute);
            System.out.println("Eiluteje rastu mazu lotinisku raidziu yra: " + raidziuSkaicius);
        }
    }

    public void daugiausiaiBalsiuTurintiZodiTekste(){
        String senasKontentas = kontentas;
        kontentas = kontentas.replaceAll("[\\r\\n]+"," ");

        String[] zodziai = kontentas.split(" ");
        String ilgiausiasZodis = surastiIlgiausiaZodi(zodziai);

        kontentas = senasKontentas;
        System.out.println("ilgigausias zodis tekste yra: " + ilgiausiasZodis);
    }

    private String  surastiIlgiausiaZodi(String[] zodziai) {
        int ilgiausiasZodisTurintisBalses = 0;
        String ilgiausiasZodis = null;

        for(String zodis : zodziai){
            int balsiuKiekisZodyje = 0;

            for (char raide : zodis.toCharArray()) {
                if(balses.contains(raide)){
                    balsiuKiekisZodyje++;
                }
            }

            if(ilgiausiasZodisTurintisBalses < balsiuKiekisZodyje){
                ilgiausiasZodisTurintisBalses = balsiuKiekisZodyje;
                ilgiausiasZodis = zodis;
            }
        }

        return ilgiausiasZodis;
    }

    public void daugiausiaiBalsiuTurintiZodiEiluteje(){
        String[] eilutes = kontentas.split("\\n");

        for(String eilute : eilutes){
            String ilgiausiasZodis = surastiIlgiausiaZodi(eilute.split(" "));
            System.out.println("Eilutė yra: " + eilute);
            System.out.println("Ilgiausias zodis yra: " + ilgiausiasZodis);
        }
    }
}
