package lt.bit.exercise.trec;

public class Main {
    public static void main(String[] args) {

//        Puodukas p = null;
//
//        p.ipilk(100);
//
//        System.out.println(p);// kadangi p savsiem neegzistuoja (null) tai jis net nezino kur ieskot tokio metodo.

        //-----------------------------------------------
//
//        Object o = new Termosas('m',5000);
//        System.out.println(o.toString());
//
        //--------------------------------------------------

//        Termosas t1 = new Termosas('b',1000);
//        Termosas t2 = new Termosas('b',1000);
//
//        System.out.println(t1);
//        System.out.println(t2);
//
//        if (t1==t2){
//            System.out.println("tas pats");
//        }else{
//            System.out.println("ne tas pats"); //nes jie yra issaugoti skirtingose vietose,nors reiksmes tokios pacios
//        }
        //------------------------------------------------

//        Termosas t1 = new Termosas('b', 1000);
//        Termosas t2 = new Termosas('b', 1000);
//
//        Object o = t1;
//
//        System.out.println(t1);
//        System.out.println(t2);
//
//        if (t1 == o) {
//            System.out.println("tas pats");//nes tos pacios saugomos vietos objektas
//        } else {
//            System.out.println("ne tas pats");
//        }

        //-----------------------------------------------------

//        Termosas t1 = new Termosas('b', 1000);
//        Termosas t2 = new Termosas('b', 1000);
//
//        Object o = t1;
//
//        System.out.println(o instanceof String);
//        System.out.println(o instanceof Object);
//        System.out.println(o instanceof Termosas);

        //-------------------------------------------------

//        Termosas t1 = new Termosas('b', 1000);
//        Termosas t2 = new Termosas('b', 1000);
//
//        Object o = new Termosas('G',3000);
//        o="labas";
//
//        System.out.println(o instanceof String);
//        System.out.println(o instanceof Object);
//        System.out.println(o instanceof Termosas);
//
//        if (o instanceof Termosas){
//            ((Termosas)o).pasildyk(100);
//        }
//        System.out.println(o);

        //--------------------------------------------------



        //---------------------------------------------------
//        Termosas t = new Termosas('Z', 1000);
//
//        Puodukas p = new Puodukas('r',300);
//
//        Puodukas p1 = t;
//
//        p1.ipilk(200);
//
//        p1= new Puodukas('b',100);
//        Termosas t1=p1; //taip aprasyt negalim,aprasom sekanciai
//        Termosas t1 = (Termosas) p1;
//        t1.pasildyk(10);//kadangi Java visvien tikrina ar t1 turi Puoduko metodus,to atlikti nebus leidziama

//        ((Termosas)p1).pasildyk(10);// nebus leidziama

        //------------------------------------------------

//        Object o = t;

//        p1.pasildyk(10); //sitas metodas aprasytas Termoso klaseje todel jo iskviesti negalim,nes mes tiesiog
//        su Puoduko klase prieinam prie Puoduko metodu

//        Termosas t1 = p; //taip padaryti neisdegs nes Termosas yra vaikines klases Puoduko atzvilgiu

//        t.ipilk(800);
//        t.pasildyk(5);
//        t.isgerk(100);
//
//        System.out.println(t); //kadangi esam apsirase toString metoda,tai jis ismes atsakyma
//
//        System.out.println(t.getKiekis());
//        System.out.println(t.getTemp());
    }
}
