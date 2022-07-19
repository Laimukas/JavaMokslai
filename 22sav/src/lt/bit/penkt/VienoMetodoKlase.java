package lt.bit.penkt;

import java.util.Arrays;

public class VienoMetodoKlase implements VienoMetodoInterface {
    private int count = 1;
    @Override
    public void darom(Object... param) {
        System.out.println("Sitas metodas kvieciamas " + count++ + " karta");
        Arrays.asList(param).stream().forEach(System.out::println);
    }
}
