package lt.bit.ketv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<String > l = new ArrayList();
        l.add("labas");
        l.add(",");
        l.add("pasauli");
        l.add("!!!");
        l.add("Kaip");
        l.add("tau");
        l.add("sekasi");
        l.add("?");
        System.out.println(l);
//        l.sort((s1, s2) -> s1.compareTo(s2));
        l.stream().sorted().forEach(System.out::print);
        System.out.println(l);
        System.out.println("----");


//        l.stream().forEach(System.out::println);
//
//        System.out.println("----------");
//
//        l.stream().forEach(e -> {
//            System.out.println(e);
//        });
        l.stream()
                .filter(s->s.length()>3)
                .sorted()
                .forEach(System.out::println);

//        List<String > nauji = l.stream()
//                .filter(s->s.length()>3)
//                .sorted()
//                .toList();
//
//        System.out.println(l);
//        System.out.println(nauji);

        l.stream()
                .map(s->s.length())
                .forEach(System.out::println);

//        long count = l.stream().count();
//        System.out.println("count rezultatas "+count);// cia tas pats kaip ir size arba lengh

        long count = l.stream()
                .filter(s->s.length()==3)
                .flatMap(s->{
                    String [] letters = s.split("");
                    System.out.println("====");
                    System.out.println(s);
                    System.out.println(Arrays.toString(letters));
                    return Arrays.stream(letters);
                })
                .map(s -> {
                    System.out.println("Mazas lasiukas: " + s);
                    return s;
                })
                .count();
        System.out.println(count);


    }
}
