package lt.bit.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder pe;
    
    @GetMapping(path = "/pass")
    @ResponseBody
    public String pass(
            @RequestParam("pass") String pass
    ) {
        return pe.encode(pass);
    }
    
    @GetMapping("login")
    public String login() {
        return "login";
    }
}
