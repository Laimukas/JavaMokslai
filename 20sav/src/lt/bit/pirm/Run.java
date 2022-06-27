package lt.bit.pirm;

public class Run {

    public String vardas = "Alius";

    public static void main(String[] args) {
        Run r = new Run();
        System.out.println("Hello " + r.vardas);
        Skaiciai s1 = new Skaiciai();
        Skaiciai s2 = new Skaiciai();
        s1.suma();
        System.out.println(Skaiciai.sk1);
        System.out.println(Skaiciai.sk2);
        System.out.println(s1.rez);
        Skaiciai.sk1 =15;
        Skaiciai.sk2 =20;
        s2.suma();
        System.out.println(Skaiciai.sk1);
        System.out.println(Skaiciai.sk2);
        System.out.println(s2.rez);

//        s1.dvigubaSuma();
//        System.out.println(s1.rez);

        System.out.println(Skaiciai.keturgubaSuma());
    }
}
