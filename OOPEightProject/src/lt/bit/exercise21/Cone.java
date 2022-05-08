package lt.bit.exercise21;

public class Cone extends ThreeDShape {

    private double r;
    private double height;

    public Cone(double r, double height){
        this.r = r;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public double calculateVolume() {
        return height * ((double) 1/3) * calculateArea();
    }
}
