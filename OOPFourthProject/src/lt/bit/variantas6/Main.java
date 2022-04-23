package lt.bit.variantas6;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Imone> imoniuSarasasArray = new ArrayList<>();
        imoniuSarasasArray.add(new Imone("ALFA", "", 1, "Beta", ""));
        imoniuSarasasArray.add(new Imone("ALFA", "", 1, "Alfa", ""));

        ImoniuSarasas imoniuSarasas = new ImoniuSarasas(imoniuSarasasArray);
        imoniuSarasas.rikiavimas();
    }
}
