package lt.bit.todo.dao;

import lt.bit.todo.data.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsDAO extends JpaRepository<Permissions, Integer>{
    
}
