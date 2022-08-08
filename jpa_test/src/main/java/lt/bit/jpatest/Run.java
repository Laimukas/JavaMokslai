package lt.bit.jpatest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.Date;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adresai_pu");
        EntityManager em = emf.createEntityManager();
//        Zmogus z = em.find(Zmogus.class,4);
//        System.out.println(z);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

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

        Zmogus z = em.find(Zmogus.class,12);
        em.remove(z);

        tx.commit();
        System.out.println("Po irasymo");
        System.out.println(z);

        em.close();
        emf.close();
    }
}
