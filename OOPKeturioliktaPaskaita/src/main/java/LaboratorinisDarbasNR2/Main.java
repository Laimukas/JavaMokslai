package LaboratorinisDarbasNR2;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final File FAILAS =
            new File("D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPKeturioliktaPaskaita\\src\\main\\resources\\tekstas.txt");

    public static void main(String[] args) throws IOException {
        FailoNuskaitytuvas failoNuskaitytuvas = new FailoNuskaitytuvas(FAILAS);
        System.out.println("Daugiausiai balsiu turintis zodis tekste.");
        failoNuskaitytuvas.daugiausiaiBalsiuTurintiZodiTekste();
        System.out.println("<<------------------------>>");
        System.out.println("Daugiausia balsiu turinti zodi eiluteje.");
        failoNuskaitytuvas.daugiausiaiBalsiuTurintiZodiEiluteje();
        System.out.println("<<------------------------>>");
        System.out.println("Nuskaityti kiek eiluciu ir koks kiekvienos eilutes ilgis.");
        failoNuskaitytuvas.nustatytiKiekEiluciuIrKoksKiekvienosEilutesIlgis();
        System.out.println("<<------------------------>>");
        System.out.println("Pasalinti ilgiausia zodi kiekvienoje eiluteje.");
        failoNuskaitytuvas.pasalintiIlgiausiaZodiKiekvienojeEiluteje();
    }

}
