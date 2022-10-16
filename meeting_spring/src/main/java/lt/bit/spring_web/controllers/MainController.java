package lt.bit.spring_web.controllers;

import lt.bit.spring_web.data.Meeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView list() throws IOException {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
