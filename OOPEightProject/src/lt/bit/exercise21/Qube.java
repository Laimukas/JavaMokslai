package lt.bit.exercise21;

public class Qube extends ThreeDShape {

    private double s;

    public Qube(double s){
        this.s = s;
    }

    @Override
    public double calculatePerimeter() {
        return 12 * s;
    }

    @Override
    public double calculateArea() {
        return 6 * Math.pow(s, 2);
    }

    @Override
    public double calculateVolume() {
        return Math.pow(s, 3);
    }

}
