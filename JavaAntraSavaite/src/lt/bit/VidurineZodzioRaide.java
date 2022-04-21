package lt.bit;

import java.sql.SQLOutput;

public class VidurineZodzioRaide {
    public static void main(String[] args) {
        String tekstas = "vyniotinis";
        System.out.println("Turimas zodis: "+tekstas);
        char raide = vidurineRaide(tekstas);
        System.out.println("Vidurine zodzio raide yra: "+raide);
    }
    // labas
    // [1]
    // 5 / 2 = 2
    // keksas
    // 6 / 2 = 3
    public static char vidurineRaide(String zodis) {
        int i = zodis.length() / 2;
        return zodis.charAt(i);
    }
}
