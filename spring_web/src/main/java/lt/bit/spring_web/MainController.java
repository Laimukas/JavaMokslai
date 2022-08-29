package lt.bit.spring_web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
    @RequestMapping("/")
    public String index() {
        return "hello";
    }
    
    @RequestMapping("/labas")
    public String labas() {
        return "labas";
    }
}
