package lt.bit.exercise.penkt;

public class Run {
//
//    public static String objektuSuma(Object o1, int sk) {
//        return o1.toString() + " " + sk + " (skaicius)";
//    }
//
//    public static String objektuSuma(Object o1, Object o2) {
//        return o1.toString() + " " + o2.toString();
//    }

    public static void main(String[] args) {

//        System.out.println(objektuSuma("Labas", 15));

//        Integer i = new Integer(7); //seniau reikejo taip rasinet,dabar uztenka taip
//        Integer a = 7;

//        Integer i = 7;
//        Integer j = 10;
//
//        int rez = i+j;
//        //        i.intValue() + j.intValue()
//        //            7        +     10
//        //                  17
//
//        System.out.println(rez);

        //bet jei rez bus Integer gausis

//        Integer i = 7;
//        Integer j = 10;
//
//        Integer rez = i+j;
//        //        i.intValue() + j.intValue()
//        //            7        +     10
//        //                  17
//        //              new Integer(17)
//
//        System.out.println(rez);
        // dabar tikrinam kaip dirbs String kai sudedinesim
        //auksciau metodas virs main

        //******************************************************************

        MyList l = new MyList();
        System.out.println(l.size()); // 0

        l.add("labas");
        System.out.println(l); // [labas]
        l.add("pasauli");
        System.out.println(l); // [labas, pasauli]
        l.add("!");
        System.out.println(l); // [labas, pasauli, !]
        System.out.println(l.size()); // 3
        System.out.println(l.get(1)); // pasauli
        System.out.println(l.get(2)); // !
        l.insert(1, "baisus");
        System.out.println(l); // [labas, baisus, pasauli, !]
        l.set(1, "zavingas");
        System.out.println(l); // [labas, zavingas, pasauli, !]
        System.out.println(l.size()); // 4
        l.remove(0);
        System.out.println(l); // [zavingas, pasauli, !]
        l.remove(2);
        System.out.println(l); // [zavingas, pasauli]

    }
}
/*
String klase yra cashable ,nes tokio pacio objekto nekuria atskiroj atminti

Vraperiai irgi yra cashable ne taip kaip Tipai

Kintamuju Tipai            Vraperiai

byte                        Byte
short                       Short
int                         Integer
long                        Long
float                       Float
double                      Double
boolean                     Boolean
char                        Character
 */