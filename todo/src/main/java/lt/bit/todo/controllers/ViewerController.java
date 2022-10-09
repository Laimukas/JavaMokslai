package lt.bit.todo.controllers;

import lt.bit.todo.config.MyUserDetails;
import lt.bit.todo.dao.TodosDAO;
import lt.bit.todo.dao.UsersDAO;
import lt.bit.todo.data.Todos;
import lt.bit.todo.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("viewer")
public class ViewerController {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private TodosDAO todosDAO;

    @GetMapping("todoView")
    public ModelAndView todoView(
            Authentication auth
//            @RequestParam("userId") Integer userId
    ) {
        ModelAndView mav = new ModelAndView("todoView");
        mav.addObject("list", usersDAO.findAll());
        mav.addObject("todos", todosDAO.findAll());
        MyUserDetails userDet = (MyUserDetails) auth.getPrincipal();
        List<Todos> visiTodos = userDet.getUser().getTodosList();
        mav.addObject("todoList", visiTodos);
        return mav;
    }

    @GetMapping("kieno")
    public ModelAndView kieno(
            @RequestParam("user_id") Integer userId
    ) {
        ModelAndView mav = new ModelAndView("kieno");
        if (userId != null) {
            mav.addObject("user", usersDAO.findById(userId));
            return mav;
        } else {
            Users u = new Users();
            u.setUserName("unknown");
            mav.addObject("user", u);
            return mav;
        }
    }
    @GetMapping("todos")
    public ModelAndView todos(
            Authentication auth
//            @RequestParam("userId") Integer userId
    ) {
        ModelAndView mav = new ModelAndView("todos");
        mav.addObject("list", usersDAO.findAll());
        mav.addObject("todos", todosDAO.findAll());
        MyUserDetails userDet = (MyUserDetails) auth.getPrincipal();
        List<Todos> visiTodos = userDet.getUser().getTodosList();
        mav.addObject("todoList", visiTodos);
        return mav;
    }

}
