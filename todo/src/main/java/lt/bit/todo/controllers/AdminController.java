package lt.bit.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lt.bit.todo.dao.PermissionsDAO;
import lt.bit.todo.dao.UsersDAO;
import lt.bit.todo.data.Permissions;
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
    private PermissionsDAO permissionsDAO;
    
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

    @GetMapping("permissions")
    public ModelAndView permissionList() {
        ModelAndView mav = new ModelAndView("permissions");
        mav.addObject("list", permissionsDAO.findAll());
        return mav;
    }
    @GetMapping("editPermission")
    public ModelAndView editPermission(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("editPermission");
        if (id == null) {
            return mav;
        }
        Optional<Permissions> oPerm = permissionsDAO.findById(id);
        if (oPerm.isPresent()) {
            mav.addObject("permission", oPerm.get());
            return mav;
        }
        return new ModelAndView("redirect:./permissions");
    }
    @PostMapping("savePermission")
    @Transactional
    public String savePerm(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "permissionName") String permissionName
    ) {
        Permissions p;
        if (id != null) {
            Optional<Permissions> oPerm = permissionsDAO.findById(id);
            if (oPerm.isEmpty()) {
                return "redirect:./permissions";
            }
            p = oPerm.get();
        } else {
            p = new Permissions();
        }
        p.setPermissionName(permissionName);
        permissionsDAO.save(p);
        return "redirect:./permissions";
    }
    @GetMapping("deletePermission")
    @Transactional
    public String deletePerm(@RequestParam(value = "id") Integer id) {
        if (id == null) {
            return "redirect:./permissions";
        }
        Optional<Permissions> oPerm = permissionsDAO.findById(id);
        if (oPerm.isPresent()) {
            permissionsDAO.delete(oPerm.get());
        }
        return "redirect:./permissions";
    }
    @GetMapping("userPermissions")
    public ModelAndView userPermissions(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("userPermissions");
        if (id == null) {
            return mav;
        }
        Optional<Users> oUser = usersDAO.findById(id);
        if (oUser.isPresent()) {
            mav.addObject("user", oUser.get());
            mav.addObject("list",userPermissions(id));
            return mav;
        }
        return new ModelAndView("redirect:./users");
    }
}
