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


public class Run {

    public static void main(String[] args) {
        Sunkvezimis savivartis = new Sunkvezimis(10, true, 3, "'MB'", "Raudona", "Savivartis");
        System.out.println(savivartis);
        System.out.println("----------------Klases------------------------'\n");
        Class clazz = savivartis.getClass();
        System.out.println("klases pavadinimas: " + clazz.getName());
        System.out.println("super klases pavadinimas: " + clazz.getSuperclass().getName());
        System.out.println("super super klases pavadinimas: " + clazz.getSuperclass().getSuperclass().getName()+"'\n");
//
//        for (int i = 0; i < clazz.getClasses().length; i++) {
//            Class aClass = clazz.getClasses()[i];
//            System.out.println(aClass.toString());
//        }

        System.out.println("---------------Metodai----------------");
        for (int i = 0; i < clazz.getMethods().length; i++) {
            Method method = clazz.getMethods()[i];
            System.out.println(method.getName());
        }

    }

}
