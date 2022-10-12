package lt.bit.todo.controllers;

import lt.bit.todo.config.MyUserDetails;
import lt.bit.todo.dao.PermissionsDAO;
import lt.bit.todo.dao.TodosDAO;
import lt.bit.todo.dao.UsersDAO;
import lt.bit.todo.data.Permissions;
import lt.bit.todo.data.Todos;
import lt.bit.todo.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private TodosDAO todosDAO;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView list(Authentication auth) {
        ModelAndView mav = new ModelAndView("todo");
        MyUserDetails userDet = (MyUserDetails) auth.getPrincipal();
        mav.addObject("user", userDet.getUser());
        mav.addObject("todos", todosDAO.pagalUseri(userDet.getUser().getId()));
//        Users user = userDet.getUser();
//        List<Todos> visiTodos = user.getTodosList();
//        for (Todos todo:visiTodos){
//            System.out.println(todo);
//        }
//        mav.addObject("list",visiTodos);//tikrint ar tinka toks varijantas ir jei ne tai kaip ka keist
        return mav;
    }

    @GetMapping("edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("save")
    @Transactional
    public String save(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "user_id") Integer userId,
            @RequestParam(value = "desc") String desc
    ) {
        Todos t;
        Optional<Users> oUsers = usersDAO.findById(userId);
        Users u = oUsers.get();
        if (id != null) {
            Optional<Todos> oTodos = todosDAO.findById(id);
            if (oTodos.isEmpty() && oUsers.isEmpty()) {
                return "redirect:./todo";
            }
            t = oTodos.get();
        } else {
            t = new Todos();
        }
        t.setUserId(u);
        t.setDesc(desc);
        todosDAO.save(t);
        return "redirect:./todo";
    }
}
