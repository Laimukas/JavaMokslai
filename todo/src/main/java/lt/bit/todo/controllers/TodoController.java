package lt.bit.todo.controllers;

import lt.bit.todo.config.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("todo")
public class TodoController {
    
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView list(Authentication auth) {
        ModelAndView mav = new ModelAndView("todo");
        MyUserDetails userDet = (MyUserDetails) auth.getPrincipal();
        mav.addObject("user", userDet.getUser());
        return mav;
    }
    
    @GetMapping("edit")
    public String edit() {
        return "edit";
    }
}
