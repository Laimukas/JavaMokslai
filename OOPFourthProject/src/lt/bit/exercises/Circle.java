package lt.bit.exercises;

public class Circle extends Shape {

    private double radius;

    public Circle(){
        super();
        radius = 1;
    }

    public Circle(String color, boolean isFilled, double radius){
        super(color, isFilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public String toString(){
        return String.format("Circle with radius = %.2f which is a sublass of %s", radius, this.getClass().getSuperclass());
    }
}
