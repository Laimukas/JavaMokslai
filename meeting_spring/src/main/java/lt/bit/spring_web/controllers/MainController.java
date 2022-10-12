package lt.bit.spring_web.controllers;


import lt.bit.spring_web.data.Meeting;
import lt.bit.spring_web.db.Db;
import lt.bit.spring_web.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final Db db = new Db();

    private final MeetingService meetingService=new MeetingService(db);

//    @GetMapping("/")
//    public ModelAndView list() throws IOException {
//        List<Meeting> list = meetingService.getAllMeetings();
//        ModelAndView mav = new ModelAndView("meetings");
//        mav.addObject("meetings", list);
//        return mav;
//    }

}
