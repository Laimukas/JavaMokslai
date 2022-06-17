package lt.bit.exercise.ketv.konstruktoriai;

public class K4 extends K3 {

   protected String reiksme;

    public K4(String r) {
        System.out.println("K4 priskiriam String");
        this.reiksme = r;
    }

//    public K4(String r, String papildymas) {
//        System.out.println("K4 priskiriam dviguba String");
//        this.reiksme = r + papildymas;
//    }

//    arba kitoks varijantas dvigubo stringo,atsakymas kitoks

    public K4(String r, String papildymas) {
        this(r + papildymas);
        System.out.println("K4 priskiriam dviguba String");

    }

    public K4(int sk) {
        this("" + sk," dar info");
        System.out.println("K4 priskiriam Int");
//        this.reiksme= ""+ sk;
    }

    @Override
    public String toString() {
        return "K4{" +
                "reiksme='" + reiksme + '\'' +
                '}';
    }
}
