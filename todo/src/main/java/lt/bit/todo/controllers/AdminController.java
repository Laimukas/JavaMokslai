package lt.bit.todo.controllers;

import java.util.Optional;
import lt.bit.todo.dao.UsersDAO;
import lt.bit.todo.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {
    
    @Autowired
    private UsersDAO usersDAO;
    
    @Autowired
    private PasswordEncoder pe;
    
    @GetMapping("users")
    public ModelAndView userList() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("list", usersDAO.findAll());
        return mav;
    }
    
    @GetMapping("editUser")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("editUser");
        if (id == null) {
            return mav;
        }
        Optional<Users> oUser = usersDAO.findById(id);
        if (oUser.isPresent()) {
            mav.addObject("user", oUser.get());
            return mav;
        }
        return new ModelAndView("redirect:./users");
    }
    
    @PostMapping("saveUser")
    @Transactional
    public String save(
        @RequestParam(value = "id", required = false) Integer id,
        @RequestParam(value = "userName") String userName,
        @RequestParam(value = "userPassword") String userPassword
    ) {
       Users u;
       if (id != null) {
            Optional<Users> oUser = usersDAO.findById(id);
            if (oUser.isEmpty()) {
                return "redirect:./users";
            }
            u = oUser.get();
       } else {
           u = new Users();
       }
       u.setUserName(userName);
       u.setUserPassword(pe.encode(userPassword));
       usersDAO.save(u);
       return "redirect:./users";
    }
    
    @GetMapping("deleteUser")
    @Transactional
    public String delete(@RequestParam(value = "id") Integer id) {
        if (id == null) {
            return "redirect:./users";
        }
        Optional<Users> oUser = usersDAO.findById(id);
        if (oUser.isPresent()) {
            usersDAO.delete(oUser.get());
        }
        return "redirect:./users";
    }
    
}
