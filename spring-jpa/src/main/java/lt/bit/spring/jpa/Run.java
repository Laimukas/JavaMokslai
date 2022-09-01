package lt.bit.spring.jpa;

import java.util.List;
import lt.bit.spring.jpa.dao.ZmogusDAO;
import lt.bit.spring.jpa.data.Zmogus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        
        ZmogusDAO zdao = ac.getBean(ZmogusDAO.class);
        List<Zmogus> list = zdao.findAll();
        System.out.println(list);
        Zmogus jonas = zdao.findById(1).get();
        System.out.println(jonas);
        
        list = zdao.filtered("p%");
        System.out.println(list);
        
    }
}
