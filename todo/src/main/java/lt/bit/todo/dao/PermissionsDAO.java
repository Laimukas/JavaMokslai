package lt.bit.todo.dao;

import lt.bit.todo.data.Permissions;
import lt.bit.todo.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PermissionsDAO extends JpaRepository<Permissions, Integer>{

    @Query(name = "Permissions.findByPermissionName")
    public List<Permissions> byName(@Param("permissionName") String permissionName);

//    @Query("select p from user_permissions p where p.user_id = :usrId")
//    public List<Permissions> pagalZmogu(
//            @Param("usrId")
//            Integer usrId);


}
