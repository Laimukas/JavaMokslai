package lt.bit.Figuros;

public class LygiakrastisTrikampis extends Figura{

    private double x;

    public LygiakrastisTrikampis(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "LygiakrastisTrikampis{" +
                "x= " + x +
                '}';
    }

    @Override
    public double perimetras() {
        return 3*x;
    }

    @Override
    public double plotas() {
        return Math.pow(x,2)*Math.sqrt(3)/4;
    }
}
