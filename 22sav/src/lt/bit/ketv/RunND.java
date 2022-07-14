package lt.bit.ketv;
//parasyti enuma su menesiais DONE
//kiekvienas menuo turi savo dienu skaiciu ir metu laika DONE
//
//parasyti metoda, kuriam butu galima paduoti bet kiek menesiu ir DONE
//jis atspausdintu metu laikus ir dienu kieki (is paduotu menesiu)

import java.util.HashMap;
import java.util.Map;

public class RunND {

    //destytojo Aliaus budas, mano yra treciadienio folderyje

    public static Map<MetuLaikai, Integer> dienosPagalMetuLaika(Menesiai ...menesiai) {
        Map<MetuLaikai, Integer> rez = new HashMap();
        for (Menesiai menesis : menesiai) {
            Integer kiek = rez.get(menesis.getMetuLaikas());
            if (kiek == null) {
                kiek = 0;
            }
            rez.put(menesis.getMetuLaikas(), kiek + menesis.getDienos());
        }
        return rez;
    }

    public static void main(String[] args) {
        System.out.println(dienosPagalMetuLaika(Menesiai.LIEPA, Menesiai.RUGPJUTIS, Menesiai.BALANDIS, Menesiai.BALANDIS, Menesiai.SAUSIS));

    }
}
