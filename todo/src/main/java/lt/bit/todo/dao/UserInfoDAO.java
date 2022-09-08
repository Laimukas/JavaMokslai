package lt.bit.todo.dao;

import lt.bit.todo.data.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDAO extends JpaRepository<UserInfo, Integer>{
    
}
