package lt.bit.lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> pasisveikinimai = new ArrayList<>(List.of("Hello", "Labas", "Bonjour"));

        for(String pasisveikinimas : pasisveikinimai){
            System.out.println(pasisveikinimas);
        }

        // parametras -> expression (išsireiškimas)
        // (par1, par2) -> expression (išsireiškimas)
        // parametras - > { code block }

        pasisveikinimai.forEach(pasisveikinimas -> System.out.println(pasisveikinimas));

        HashMap<String, String> zmogausData = new HashMap<>();
        zmogausData.put("39213123123123123", "adresas");
        zmogausData.put("23423432423423423", "adresas1");

        zmogausData.forEach((asmensKodas, adresas) ->
                System.out.println(String.format("Asmens kodas yra: %s, adresas: %s", asmensKodas, adresas)));

        KariuomenesValidatorius kariuomenesValidatorius = zmogus -> zmogus.getAmzius() >= 18 && !zmogus.getLytis().equals(Lytis.NONE);
        Zmogus zmogus = new Zmogus("Edvinas", 26, Lytis.VYRAS);
        Kariuomene kariuomene = new Kariuomene();
        kariuomene.arTinkateKariuomenei(zmogus, kariuomenesValidatorius);
    }
}
