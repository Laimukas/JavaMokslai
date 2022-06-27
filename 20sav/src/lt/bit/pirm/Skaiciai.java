package lt.bit.pirm;

public class Skaiciai {

    public static int sk1 = 1;

    public static int sk2 = 2;

    public int rez = 0;

    public void suma() {
        this.rez = sk1 + sk2;
    }

    public int dvigubaSuma() {
        suma();
        this.rez *= 2;
        return this.rez;
    }

    public static int keturgubaSuma() {
        return (sk1 + sk2) * 4;
    }
}
