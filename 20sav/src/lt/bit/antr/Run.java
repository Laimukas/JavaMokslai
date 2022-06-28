package lt.bit.antr;

public class Run {

    public static void main(String[] args) {

        MyLinkedList l = new MyLinkedList();
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
