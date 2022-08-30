package lt.bit.spring_web;

import java.util.List;
import lt.bit.spring_web.data.Db;
import lt.bit.spring_web.data.Preke;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @GetMapping("/")
    public ModelAndView list() {
        List<Preke> list = Db.list();
        ModelAndView mav = new ModelAndView("prekes");
        mav.addObject("prekes", list);
        return mav;
    }
    
    @GetMapping("preke/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) {
        Preke p = Db.getOne(id);
        ModelAndView mav = new ModelAndView("preke");
        mav.addObject("preke", p);
        return mav;
    }
    
    @GetMapping("preke/new")
    public ModelAndView newRecord() {
        ModelAndView mav = new ModelAndView("preke");
        return mav;
    }
    
    @PostMapping("save")
    public String save(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("pavadinimas") String pavadinimas,
            @RequestParam("kiekis") Float kiekis
    ) {
        if (id == null) {
            Preke p = new Preke(pavadinimas, kiekis);
            Db.add(p);
        } else {
            Preke p = new Preke(id, pavadinimas, kiekis);
            Db.update(p);
        }
        return "redirect:/";
    }
    
    @GetMapping("preke/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        Db.delete(id);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String index() {
        return "hello";
    }
    
//    @RequestMapping(value = "/labas", method = {RequestMethod.POST})
    @PostMapping("/labas")
    public String labas() {
        System.out.println("viekia labas POST !!!");
        return "labas";
    }
    
    @RequestMapping(value = "/labas", method = {RequestMethod.GET})
//    @GetMapping("/labas")
    public String labasGet() {
        System.out.println("viekia labas get !!!");
        return "labas";
    }
}
