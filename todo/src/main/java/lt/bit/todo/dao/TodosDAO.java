package lt.bit.todo.dao;

import lt.bit.todo.data.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosDAO extends JpaRepository<Todos, Integer>{
    
}
