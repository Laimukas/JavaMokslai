package lt.bit.spring.jpa.dao;

import java.util.List;
import lt.bit.spring.jpa.data.Zmogus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ZmogusDAO extends JpaRepository<Zmogus, Integer>{
    
    @Query("select z from Zmogus z where UPPER(z.pavarde) like UPPER(:filter)")
    public List<Zmogus> filtered(@Param("filter") String filtras);
    
}
