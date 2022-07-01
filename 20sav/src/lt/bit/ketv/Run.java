package lt.bit.ketv;

import java.util.HashSet;
import java.util.Set;

public class Run {
    public static void main(String[] args) {

        //HashSet

        Zmogus z1 = new Zmogus("Jonas","Jonaitis",1999);
        Zmogus z2 = new Zmogus("Petras","Petraitis",null);
        Zmogus z3 = new Zmogus("Andrius","Andraitis",2006);
        Zmogus z4 = new Zmogus("Vardenis","Pavardenis",1982);
        Zmogus z5 = new Zmogus("Jonas","Jonaitis",1999);

        Set<Zmogus> zmones = new HashSet<Zmogus>();

        zmones.add(z1);
        zmones.add(z2);
        zmones.add(z3);

        System.out.println(zmones);

//        zmones.add(z1);

//        z1.setVardas("Kitoks Jonas");

        zmones.add(z5);

        System.out.println(zmones);

        System.out.println(z1.equals(z1)); //true
        System.out.println(z1.equals(z5)); //false

        System.out.println(z1.getVardas().equals(z5.getVardas()) && z1.getPavarde().equals(z5.getPavarde()));//true




//        System.out.println(zmones.contains(z2));
//        System.out.println(zmones.contains(z4));
//
//        for (Zmogus zmogus : zmones){
//            System.out.println(zmogus);
//        }

    }
}
