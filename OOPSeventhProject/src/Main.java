import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Element.display(10);
        Element.display("tekstas");
        Element.display(10.66);
        Element.display(25f);
        Element.display(true);
        Element.display(3.14);

        Box<Integer> box = new Box<>(new ArrayList<>(List.of(10, 20, 30)));
//        Box<String> box1 = new Box<>(new ArrayList<>(List.of("Hello")));
        box.displayArray();
    }
}
