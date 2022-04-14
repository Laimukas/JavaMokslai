package lt.bit;

public class VidurineZodzioRaide {
    public static void main(String[] args) {
        String tekstas = "labas";
        char raide = vidurineRaide(tekstas);
        System.out.println(raide);
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
