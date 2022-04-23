package lt.bit.exercises;

public class Main {

    public static void main(String[] args) {
        Square square = new Square("Raudona", true, 10, 10);

        System.out.println(square.getColor());
        System.out.println(square.getPerimeter());
        System.out.println(square.getArea());
        System.out.println(square);
    }
}
