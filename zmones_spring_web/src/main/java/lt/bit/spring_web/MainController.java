package lt.bit.spring_web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import lt.bit.spring_web.data.Zmogus;
import lt.bit.spring_web.data.ZmogusDb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final String ZMONES_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\zmones_spring_web\\src\\main\\resources\\data\\zmones.txt";

    @GetMapping("/")
    public ModelAndView list() throws IOException {
        ZmogusDb zmonesS = new ZmogusDb();
        ArrayList<Zmogus> list = zmonesS.getArrayListFromFile(new File(ZMONES_FILE_PATH));
        ModelAndView mav = new ModelAndView("zmones");
        mav.addObject("zmones", list);
        return mav;
    }

    @GetMapping("zmogus/{id}")
    public ModelAndView show(@PathVariable("id") Integer id)throws IOException {
        ZmogusDb zmonesS = new ZmogusDb();
        Zmogus z = zmonesS.getOne(id,new File(ZMONES_FILE_PATH));
        ModelAndView mav = new ModelAndView("zmogus");
        mav.addObject("zmogus", z);
        return mav;
    }

    @GetMapping("zmogus/new")
    public ModelAndView newRecord() {
        ModelAndView mav = new ModelAndView("zmogus");
        return mav;
    }

    @PostMapping("save")
    public String save(

            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("vardas") String vardas,
            @RequestParam("pavarde") String pavarde,
            @RequestParam("amzius") Float amzius
    ) throws IOException{
        ZmogusDb zmonesS = new ZmogusDb();
        if (id == null) {
            Zmogus z = new Zmogus(vardas,pavarde, amzius);
            zmonesS.addZmogus(z,new File(ZMONES_FILE_PATH));
        } else {
            Zmogus z = new Zmogus(id, vardas,pavarde,amzius);
            zmonesS.zmogusUpdate(z,new File(ZMONES_FILE_PATH));
        }
        return "redirect:/";
    }

    @GetMapping("zmogus/{id}/delete")
    public String delete(@PathVariable("id") Integer id) throws IOException {
        ZmogusDb zmonesS = new ZmogusDb();
        zmonesS.zmogusDelete(id,new File(ZMONES_FILE_PATH));
        return "redirect:/";
    }

}
