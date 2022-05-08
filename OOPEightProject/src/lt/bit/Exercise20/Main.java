package lt.bit.Exercise20;

public class Main {
    public static void main(String[] args) {
        Hexagon hexagon = new Hexagon(10);
        System.out.println("Area of Hexagon = "+hexagon.calculateArea());
        System.out.println("Perimeter of Hexagon = "+hexagon.calculatePerimeter());

        Rectangle rectangle=new Rectangle(5,7);
        System.out.println("Area of Rectangle = "+rectangle.calculateArea());
        System.out.println("Perimeter of Rectangle = "+rectangle.calculatePerimeter());

        Triangle triangle = new Triangle(4,9,6,5);
        System.out.println("Area of Triangle = "+triangle.calculateArea());
        System.out.println("Perimeter of Triangle = "+triangle.calculatePerimeter());
    }
}
