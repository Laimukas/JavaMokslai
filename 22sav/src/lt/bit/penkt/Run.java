package lt.bit.penkt;

import java.util.Arrays;

public class Run {
    public static void darytojas(VienoMetodoInterface vmi) {
        vmi.darom(5, 6, 7);
        vmi.darom(8, 9);
    }
    public static void main(String[] args) {
//        VienoMetodoKlase vmk = new VienoMetodoKlase();
//
//        VienoMetodoInterface vmi = new VienoMetodoInterface() {
//            private int count = 1;
//            @Override
//            public void darom(Object... param) {
//                System.out.println("Sitas metodas kvieciamas " + count++ + " karta");
//                Arrays.asList(param).stream().forEach(System.out::println);
//            }
//        };
        class Counter {
            int count = 1;
        }
        final Counter counter = new Counter();
        VienoMetodoInterface vmi = (param) -> {
            System.out.println("Sitas metodas kvieciamas " + counter.count++ + " karta");
            Arrays.asList(param).stream().forEach(System.out::println);
        };
        vmi.darom(1, 2, 3, 4);
        darytojas(vmi);
    }
}
