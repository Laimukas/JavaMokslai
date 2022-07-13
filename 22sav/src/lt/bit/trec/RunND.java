package lt.bit.trec;

//parasyti enuma su menesiais DONE
//kiekvienas menuo turi savo dienu skaiciu ir metu laika DONE
//
//parasyti metoda, kuriam butu galima paduoti bet kiek menesiu ir DONE
//jis atspausdintu metu laikus ir dienu kieki (is paduotu menesiu)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RunND {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList norimiMenesiai = new ArrayList();

        System.out.println("Veskite norimus menesius skaiciuku, pvz: vasaris-2, gruodis-12");
        System.out.println("Pasirinkus 0, baigsite menesiu delione, ir gausite rezultatus.");
        int i = 1;
        String metuLaikai;
        Integer dienuKiekis;
        HashMap<String, Integer> laikaiDienos = new HashMap<>();
        while (i != 0) {
            System.out.println("Kokio pageidauji menesio (vesk skaiciu)? ");
            i = Integer.parseInt(scanner.nextLine());
            if (i > 0) {

                String menuo = Menesiai.menesis(i).name();
                norimiMenesiai.add(menuo);
                metuLaikai = Menesiai.menesis(i).getMetuLaikai();
                dienuKiekis = Menesiai.menesis(i).getMenesioDienos();
//                System.out.println(laikaiDienos.containsKey(metuLaikai));
                if (laikaiDienos.isEmpty()){                                    //jei hashmap tuscias
                    laikaiDienos.put(String.valueOf(metuLaikai), dienuKiekis);
                }else if (laikaiDienos.containsKey(metuLaikai)==true) {         //jei mape jau yra toks key
                    Integer a = laikaiDienos.get(metuLaikai);
//                    System.out.println("ankstesnis "+metuLaikai+ " rezultatas "+ a);
                    Integer suma = a + dienuKiekis;
//                    System.out.println("susumavus "+metuLaikai+ " rezultatas gaunasi "+suma);
                    Integer finalDienuKiekis = dienuKiekis;
                    laikaiDienos.computeIfPresent(metuLaikai,(key, oldValue)->oldValue+ finalDienuKiekis);
                    System.out.println("atnaujintas hashmap "+laikaiDienos);
                }else if (laikaiDienos.containsKey(metuLaikai)!=true) {         //jei mape nera tokio key
                    laikaiDienos.put(metuLaikai,dienuKiekis);
                    System.out.println("atnaujintas hashmap "+laikaiDienos);
                }

                System.out.println("Menuo " + Menesiai.menesis(i) + " ikrautas i Lista.");

            }
        }
        System.out.println("*-----------------------*");
        System.out.println("Rezultatai sukurti is menesiu: " + norimiMenesiai);
        System.out.println("Sezonai ir gautos dienos is menesiu: "+laikaiDienos);
    }

}
