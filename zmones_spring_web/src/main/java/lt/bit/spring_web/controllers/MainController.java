package lt.bit.spring_web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lt.bit.spring_web.classes.Kontaktas;
import lt.bit.spring_web.classes.Zmogus;
import lt.bit.spring_web.db.KontaktasDB;
import lt.bit.spring_web.db.ZmogusDb;
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

    private static final String KONTAKTAI_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\zmones_spring_web\\src\\main\\resources\\data\\kontaktai.txt";

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

    @GetMapping("kontaktai")
    public ModelAndView kontaktaiList() throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> list = kontaktasDB.getArrayListFromFile(new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }

    @GetMapping("kontaktas/{kontId}")
    public ModelAndView showKontaktas(@PathVariable("kontId") Integer id)throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        Kontaktas kontaktas = kontaktasDB.getOne(id,new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktas");
        mav.addObject("kontaktas", kontaktas);
        return mav;
    }
    @GetMapping("zmogus/{id}/kontaktai")
    public ModelAndView kontaktaiListByZmogus(@PathVariable("id") Integer id) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        List<Kontaktas> list = kontaktasDB.getKontaktaiByZmogus(id,new File(KONTAKTAI_FILE_PATH));
        ModelAndView mav = new ModelAndView("kontaktai");
        mav.addObject("kontaktai", list);
        return mav;
    }
    @PostMapping("zmogus/{zmId}/saveKont")
    public String saveKont(

            @RequestParam(value = "kontId", required = false) Integer kontId,
            @PathVariable("zmId") Integer zmId,
            @RequestParam("tipas") String tipas,
            @RequestParam("reiksme") String reiksme
    ) throws IOException{
        KontaktasDB kontaktasDB = new KontaktasDB();
        if (kontId == null) {
            Kontaktas k = new Kontaktas(zmId,tipas, reiksme);
            kontaktasDB.addKontaktas(k,new File(KONTAKTAI_FILE_PATH));
        } else {
            Kontaktas k = new Kontaktas(kontId,zmId,tipas, reiksme);
            kontaktasDB.kontaktasUpdate(k,new File(KONTAKTAI_FILE_PATH));
        }
        return "redirect:/";
    }
    //sita tvarkytis nes nepagauna zmId, ir nesigauna naujo kurtis kontakto,nes reikalingas zmogaus Id
    @GetMapping("zmogus/{zmId}/kontaktas/new")
    public ModelAndView newRecordKont(@PathVariable("zmId") Integer zmId) {
        ModelAndView mav = new ModelAndView("kontaktas");
        return mav;
    }
    @GetMapping("kontaktas/{kontId}/delete")
    public String deleteKont(@PathVariable("kontId") Integer id) throws IOException {
        KontaktasDB kontaktasDB = new KontaktasDB();
        kontaktasDB.kontaktasDelete(id,new File(KONTAKTAI_FILE_PATH));
        return "redirect:/";
    }

}
