package lt.bit.antr.interfeisai;

public class Virdulys implements Elektra {

    private int temp = 20;

    @Override
    public void ijunk() {
        System.out.println("Virduli ijungem");
        this.temp=100;
    }

    @Override
    public void isjunk() {
        System.out.println("Virduli isjungem");
        this.temp=20;
    }

    @Override
    public String toString() {
        return "Virdulys{" +
                "temp=" + temp +
                '}';
    }
}
