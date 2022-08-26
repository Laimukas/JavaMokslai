package lt.bit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {

        System.out.println("--Pradzia--");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("--sukurem konteksta--");

//        Taskas pradzia = (Taskas) ac.getBean("pradzia");
//        System.out.println(pradzia);
//        Taskas vienetas = (Taskas) ac.getBean("vienetas");
//        System.out.println(vienetas);
//        System.out.println(pradzia == vienetas);

//        System.out.println("------");
//        Atkarpa a = (Atkarpa) ac.getBean("linija1");
//        System.out.println(a);
//        Atkarpa a1 = (Atkarpa) ac.getBean("linija1");
//        System.out.println(a1);
//        System.out.println(a == a1);

//        System.out.println("------");
//        Atkarpa a = (Atkarpa) ac.getBean("linija1");
//        System.out.println(a);
//        a.getIki().setX(55);
//        a.getIki().setY(33);
//        System.out.println(a);
//
//        Atkarpa a1 = (Atkarpa) ac.getBean("linija1");
//        System.out.println(a1);
//        System.out.println(a == a1);
//
//        System.out.println(pradzia);
//        System.out.println(ac.getBean("pradzia"));
//        System.out.println(pradzia == ac.getBean("pradzia"));

        //------------------ND---------------------------------

        Taskas pradzia = (Taskas) ac.getBean("pradzia");
        System.out.println(pradzia);
        Taskas antras = (Taskas) ac.getBean("antras");
        System.out.println(antras);
        Taskas trecias = (Taskas) ac.getBean("trecias");
        System.out.println(trecias);
        Taskas ketvirtas = (Taskas) ac.getBean("ketvirtas");
        System.out.println(ketvirtas);

        System.out.println(" ----- Pridavem taskus ------------");

        System.out.println("------------- 1 -----------------");

        Keturkampis ket1 = (Keturkampis) ac.getBean("keturk1");
        System.out.println(ket1);

        System.out.println("------------- 2 -----------------");

        Keturkampis ket2 = (Keturkampis) ac.getBean("keturk2");
        System.out.println(ket2);

        System.out.println("------------- 3 -----------------");

        Keturkampis ket3 = (Keturkampis) ac.getBean("keturk3");
        System.out.println(ket3);

        System.out.println("------- kuriam linijas is keturkampio tasku ----------");

        System.out.println("-- atkarpa A ----");
        Atkarpa a = (Atkarpa) ac.getBean("linija");
        System.out.println(a);
        a.setNuo(pradzia);
        a.setIki(antras);
        System.out.println(a);
        System.out.println("-- atkarpa B ----");
        Atkarpa b = (Atkarpa) ac.getBean("linija");
        System.out.println(b);
        b.setNuo(ketvirtas);
        b.setIki(antras);
        System.out.println(b);
        System.out.println("-- atkarpa C ----");
        Atkarpa c = (Atkarpa) ac.getBean("linija1");
        System.out.println(c);
        c.setNuo(pradzia);
        c.setIki(trecias);
        System.out.println(c);
        System.out.println("-- atkarpa D ----");
        Atkarpa d = (Atkarpa) ac.getBean("linija1");
        System.out.println(d);
        d.setNuo(trecias);
        d.setIki(ketvirtas);
        System.out.println(d);


    }
}
//    klase Keturkampis
//    turi savybes (Taskas):
//        ak
//        vk
//        ad
//        vd
//
//
//
//        turi du konstruktorius:
//default (koordinates: 0,0; 0,1; 1,0; 1,1)
//        su keturias parametrais
//
//
//
//        aprasyti spring.xml'e 3 keturkampius
//        1-as: default (prototipas)
//        2-as: kuriamas su 4-iu parametru konstruktorium
//        paduodant reiksmes su "ref" t.y. reikia aprasyti spring.xml'e ir visus 4 taskus
//        3-as: kuriamas su default konstruktorium
//        paduodant reiksmes su atskiru bean'u kiekvienai savybei