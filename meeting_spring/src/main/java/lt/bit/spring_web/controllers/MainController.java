package lt.bit.spring_web.controllers;

import lt.bit.spring_web.data.Meeting;
import lt.bit.spring_web.data.Person;
import lt.bit.spring_web.db.Db;
import lt.bit.spring_web.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    private final Db db = new Db();

    private final MeetingService meetingService=new MeetingService(db);

    @GetMapping("/")
    public ModelAndView list() throws IOException {
        List<Meeting> list = meetingService.getAllMeetings();
        ModelAndView mav = new ModelAndView("meetings");
        mav.addObject("meetings", list);
        return mav;
    }


    @GetMapping("meeting/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) throws IOException {
        Meeting m = meetingService.getOneMeeting (meetingService.getAllMeetings(), id);
        ModelAndView mav = new ModelAndView("meeting");
        mav.addObject("meeting", m);
        return mav;
    }

    @GetMapping("meeting/new")
    public ModelAndView newRecord() {
        ModelAndView mav = new ModelAndView("meeting");
        return mav;
    }

    @PostMapping("save")
    public String save(

            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("name") String name,
            @RequestParam("responsiblePerson") Person respPerson,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("type") String type,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("atendees") List<Integer> atendees
    ) throws IOException{
        if (id == null) {
            Meeting meeting = new Meeting(name,respPerson,description,category,type,startDate,endDate,atendees);
            meetingService.addNewMeeting(meeting);
        } else {
            Meeting meeting = new Meeting(id,name,respPerson,description,category,type,startDate,endDate,atendees);
            meetingService.updateMeeting(meeting);
        }
        return "redirect:/";
    }

    @GetMapping("meeting/{id}/delete")
    public String delete(@PathVariable("id") Integer id) throws IOException {
        meetingService.deleteMeeting(id);
        return "redirect:/";
    }

}
