package lt.bit;

//parasyti metoda, i kuri padavus klase, grazintu klasiu sarasa (MyList), nuo kuriu yra paveldeta sita klase
//
//
//parasyti metoda, i kuri padavus klase, grazintu metodu sarasa (MyList) stingai forma: Klase.metodas
//
//public MyList classList(Class cl) {
//// todo
//}
//cl: SuperCar
//ret:
//SuperCar
//Car
//Transport
//Object
//
//
//public MyList methodList(Class cl) {
//// todo
//}
//cl: Obluolys
//ret:
//Obuolys.nokstam
//Obuolys.toString
//Object.hashcode
//Object.equals
//Object.wait
//....

import java.lang.reflect.Method;
import java.util.Arrays;


public class Run {
// metodas destytojo Aliaus klasiu medziui rasti

    public static MyList classList(Class cl){
        MyList l = new MyList();
        if (cl == null){
            return l;
        }
        l.add(cl.getName());
        MyList parents = classList(cl.getSuperclass());
        for (int i =0;i<parents.size();i++){
            l.add(parents.get(i));
        }
        return l;
    }

    public static MyList methodList(Class cl){
        MyList l = new MyList();
        if (cl == null){
            return l;
        }
        l.add(cl.getName());

        for (int i = 0; i < cl.getMethods().length; i++) {
            l.add(cl.getMethods()[i]);
        }
        return l;
    }

    public static void main(String[] args) throws Exception{
        Sunkvezimis savivartis = new Sunkvezimis(10, true, 3, "'MB'", "Raudona", "Savivartis");
        System.out.println(savivartis);
        System.out.println("----------------Klases------------------------'\n");
        Class clazz = savivartis.getClass();
// ---------------  cia tiesiog pasitikrinimui ar teisybe ismeta
//        System.out.println("klases pavadinimas: " +clazz.getName());
//        System.out.println("super klases pavadinimas: " + clazz.getSuperclass().getName());
//        System.out.println("super super klases pavadinimas: " + clazz.getSuperclass().getSuperclass().getName()+"'\n");

        //------------ cia aprasom kad klasiu medi nuo klases Sunkvezimis surasytu
        MyList l = classList(Sunkvezimis.class);
        System.out.println(l);


        System.out.println("---------------Metodai----------------");

        MyList k = methodList(Sunkvezimis.class);
        System.out.println(k);

        // --------------------------  tiesioginis varijantas be metodo
//        for (int i = 0; i < clazz.getMethods().length; i++) {
//            Method method = clazz.getMethods()[i];
//            System.out.println(method.getName());
//        }

    }

}
