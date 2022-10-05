package lt.bit.todo.controllers;

import lt.bit.todo.dao.TodosDAO;
import lt.bit.todo.dao.UsersDAO;
import lt.bit.todo.data.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("viewer")
public class ViewerController {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private TodosDAO todosDAO;

    @GetMapping("todoView")
    public ModelAndView todoView(
//            @RequestParam("userId") Integer userId
    ) {
        ModelAndView mav = new ModelAndView("todoView");
        mav.addObject("list", usersDAO.findAll());
        mav.addObject("todos",todosDAO.findAll());
//        List<Todos> visiTodos = todosDAO.pagalUseri(userId);
//        mav.addObject("list", visiTodos);
        return mav;
    }

}
