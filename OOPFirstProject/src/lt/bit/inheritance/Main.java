package lt.bit.inheritance;

public class Main {

    public static void main(String[] args) {
        Dviratis dviratis = new Dviratis(2, 2.2, 40);
        Automobilis automobilis = new Automobilis(4, 3232.21, 180, 2.5);

        System.out.println("Dviracio ratu skaicius: " + dviratis.getRatuSkaicius());
        System.out.println("Automobilio ratu skaicius: " + automobilis.getRatuSkaicius() + " , o variklio turis: " + automobilis.getVarikloTuris());
    }


    // CTRL + ALT + L -> formatavimas.
}
