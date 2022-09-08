package lt.bit.todo.dao;

import java.util.List;
import lt.bit.todo.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersDAO extends JpaRepository<Users, Integer>{
    
    @Query(name = "Users.findByUserName")
    public List<Users> byName(@Param("userName") String userName);
    
}
