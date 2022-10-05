package lt.bit.todo.controllers;

import lt.bit.todo.config.MyUserDetails;
import lt.bit.todo.dao.PermissionsDAO;
import lt.bit.todo.dao.TodosDAO;
import lt.bit.todo.data.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodosDAO todosDAO;
    
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView list(Authentication auth) {
        ModelAndView mav = new ModelAndView("todo");
        MyUserDetails userDet = (MyUserDetails) auth.getPrincipal();
        mav.addObject("user", userDet.getUser());
//        List<Todos> visiTodos = todosDAO.pagalUseri(userDet.getUser().getId());
//        mav.addObject("list",visiTodos);//tikrint ar tinka toks varijantas ir jei ne tai kaip ka keist
        return mav;
    }
    
    @GetMapping("edit")
    public String edit() {
        return "edit";
    }
}
