package lt.bit.vidinesKlases;

public class Run {
    public static void main(String[] args) {
        Bankas swed = new Bankas("SWED");
        Bankas seb = new Bankas("SEB");
        Bankas.Saskaita jsw = swed.new Saskaita("Jonas", "Jonaitis");
        Bankas.Saskaita jseb = seb.new Saskaita("Jonas", "Jonaitis");
        Bankas.Saskaita psw = swed.new Saskaita("Petras", "Petraitis");
        psw.inesti(50);
        jsw.inesti(100);
        jsw.inesti(200);
        jseb.inesti(45);
        System.out.println(swed);
        System.out.println(seb);
    }
}
