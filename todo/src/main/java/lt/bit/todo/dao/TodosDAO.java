package lt.bit.todo.dao;

import lt.bit.todo.data.Todos;
import lt.bit.todo.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodosDAO extends JpaRepository<Todos, Integer>{

    @Query("SELECT t FROM Todos t WHERE t.userId.id = :user_id")
    public List<Todos> pagalUseri(
            @Param("user_id")
            Integer user_id);

}
