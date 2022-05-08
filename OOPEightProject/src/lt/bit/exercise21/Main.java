package lt.bit.exercise21;

public class Main {

    public static void main(String[] args) {
        Qube qube = new Qube(10);

        System.out.println("Qube Perimeter -> "+qube.calculatePerimeter());
        System.out.println("Qube Volume -> "+qube.calculateVolume());

        Cone cone = new Cone(5,1.5);
        System.out.println("Cone Volume -> "+cone.calculateVolume());
        System.out.println(cone.fill(50));

    }
}
