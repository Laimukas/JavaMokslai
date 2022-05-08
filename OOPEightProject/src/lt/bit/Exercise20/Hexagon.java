package lt.bit.Exercise20;

public class Hexagon extends Shape{

    private double s;

    public Hexagon(double s){
        this.s=s;
    }

    @Override
    public double calculatePerimeter() {
        return 6*s;
    }

    @Override
    public double calculateArea() {
        return (Math.sqrt(27)*Math.pow(s,2))/2;
    }
}
