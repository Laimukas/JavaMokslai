package lt.bit.spring_web.controllers;

import lt.bit.spring_web.classes.Kontaktas;
import lt.bit.spring_web.classes.Zmogus;
import lt.bit.spring_web.db.KontaktasDB;
import lt.bit.spring_web.db.ZmogusDb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class KontaktasController {

    private static final String KONTAKTAI_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\zmones_spring_web\\src\\main\\resources\\data\\kontaktai.txt";

    @GetMapping("kontaktai/")
    public ModelAndView list() throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        ArrayList<Kontaktas> list = kontaktasDB.getArrayListFromFile(new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }

    @GetMapping("kontaktas/{kontId}")
    public ModelAndView show(@PathVariable("kontId") Integer id)throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        Kontaktas kontaktas = kontaktasDB.getOne(id,new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktas");
        mav.addObject("kontaktas", kontaktas);
        return mav;
    }
    @GetMapping("zmogus/${zmogus.id}/kontaktai")
    public ModelAndView listByZmogus(@PathVariable("id") Integer id) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        ArrayList<Kontaktas> list = kontaktasDB.getKontaktaiByZmogus(id,new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }

}
