package lt.bit.jpatest;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adresai_pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Zmogus z = em.find(Zmogus.class,1);
        Query q = em.createQuery("select k from Kontaktas k where k.zmogus = :zmog");
        q.setParameter("zmog",z);
        List list = q.getResultList();
        System.out.println(list);
        Kontaktas k = new Kontaktas(null,"mob","23e452");
        k.setZmogus(z);
        em.persist(k);
        System.out.println("pridejom,bet i DB dar neirasyta");
        System.out.println(list);

//        Query q = em.createQuery("select z from Zmogus z");
//        List<Zmogus> list = q.getResultList();
//
////        List list = q.getResultList();
////        System.out.println(list);
//
//        for (Zmogus zmogus : list){
//            System.out.println(zmogus.getVardas() + " kontaktu sarasas");
////            q = em.createQuery("select k from Kontaktas k where k.zmogusId = " + zmogus.getId());
//            //arba
////            q = em.createQuery("select k from Kontaktas k where k.zmogusId = :zId");
////            q.setParameter("zId",zmogus.getId());
////            List klist = q.getResultList();
////            System.out.println(klist);
//
//            System.out.println(zmogus.getKontaktai());
//            if (zmogus.getId() ==1){
//                Kontaktas k = new Kontaktas(null,null,"mob","12345679"); //cia taip darant reik kontaktu klase koreguot,visus zmogusid reiksmes trint,nenaudosim
//                em.persist(k);
//                zmogus.getKontaktai().add(k);
//            }

            System.out.println("---------------");

        tx.commit();
        em.close();
        emf.close();

        }

//        Zmogus z = em.find(Zmogus.class,4);
//        System.out.println(z);

//        EntityTransaction tx = em.getTransaction();
//        tx.begin();

//        Zmogus z = new Zmogus();
//        z.setVardas("jpavardas");
//        z.setPavarde("jpavardas");
//        z.setAlga(BigDecimal.TEN);
//        System.out.println("Pries irasant");
//        System.out.println(z);
//        em.persist(z);

//        Zmogus z = em.find(Zmogus.class,12);
//        z.setPavarde("jpapavarde");
//        z.setGimimoData(new Date());
//        z.setAlga(BigDecimal.valueOf(3000));

//        Zmogus z = em.find(Zmogus.class,12);
//        em.remove(z);
//
//        tx.commit();
//        System.out.println("Po irasymo");
//        System.out.println(z);

//
//        tx.commit();
//        em.close();
//        emf.close();
    }

