package lt.bit.antr.interfeisai;

public class Run {

    public static void ijungejas(Elektra e){
        System.out.println("metodas ijungejas");
        e.ijunk();
        System.out.println(e);
    }

    public static void main(String[] args) {
        Namas n = new Namas("Gedimino 1");
        Virdulys v = new Virdulys();

        System.out.println(n.getAdresas());

        Elektra e = n;
        e.ijunk();
//        System.out.println(e.getAdresas); //neleidzia nes sito metodo elektra nemato

        e=v;
        e.ijunk();
        System.out.println(v.toString());

//        ijungejas(n);
//        ijungejas(v);

    }
}
