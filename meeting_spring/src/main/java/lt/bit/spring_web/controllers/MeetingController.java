package lt.bit.spring_web.controllers;

import lt.bit.spring_web.data.Meeting;
import lt.bit.spring_web.data.Person;
import lt.bit.spring_web.db.MeetingDb;
import lt.bit.spring_web.db.PersonDb;
import lt.bit.spring_web.service.MeetingService;
import lt.bit.spring_web.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MeetingController {

    private final MeetingDb meetingDb = new MeetingDb();
    private final PersonDb personDb = new PersonDb();

    private final MeetingService meetingService=new MeetingService(meetingDb);
    private final PersonService personService=new PersonService(personDb);

    @GetMapping("/meetings")
    public ModelAndView list() throws IOException {
        List<Meeting> list = meetingService.getAllMeetings();
        ModelAndView mav = new ModelAndView("meetings");
        mav.addObject("meetings", list);
        return mav;
    }

    @GetMapping("meeting/{id}")
    public ModelAndView show(@PathVariable("id") Integer id) throws IOException {
        Meeting m = meetingService.getOneMeeting (meetingService.getAllMeetings(), id);
        Person p = m.getResponsiblePerson();
        ModelAndView mav = new ModelAndView("meeting");
        mav.addObject("meeting", m);
        mav.addObject("person" , p);
        return mav;
    }

    @GetMapping("meeting/new")
    public ModelAndView newRecord() {
        List<Person> respPersons = personService.getResponsiblePersonList(personService.getAllPeople());
        ModelAndView mav = new ModelAndView("newMeeting");
        mav.addObject("list",respPersons);
        return mav;
    }

    @PostMapping("meeting/{id}/save")
    public ModelAndView save(
            @PathVariable(value = "id", required = false) Integer id,
            @RequestParam("name") String name,
            @RequestParam("respPerName") String respPerName,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("type") String type,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("atendees") List<Integer> atendees
    ) throws IOException{
        ModelAndView mav;
        List<Meeting> list = new ArrayList<>();
        if (id == null) {
            Person person = personService.getPersonByName(personService.getAllPeople(),respPerName);
            Meeting meeting = new Meeting(name,person,description,category,type,startDate,endDate,atendees);
            meetingService.addNewMeeting(meeting);
            list = meetingService.getAllMeetings();
            mav = new ModelAndView("meetings");
            mav.addObject("meetings", list);
        } else {
            Person person = personService.getPersonByName(personService.getAllPeople(),respPerName);
            Meeting meeting = new Meeting(id,name,person,description,category,type,startDate,endDate,atendees);
            meetingService.updateMeeting(meeting);
            list = meetingService.getAllMeetings();
            mav = new ModelAndView("meetings");
            mav.addObject("meetings", list);
        }
        return mav;
    }
    @PostMapping("meeting/saveNew")
    public ModelAndView saveNewMeet(
            @PathVariable(value = "id", required = false) Integer id,
            @RequestParam("name") String name,
            @RequestParam("respPerName") String respPerName,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("type") String type,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("atendees") List<Integer> atendees
    ) throws IOException{
        ModelAndView mav;
        List<Meeting> list = new ArrayList<>();
        if (id == null) {
            Person person = personService.getPersonByName(personService.getAllPeople(),respPerName);
            Meeting meeting = new Meeting(name,person,description,category,type,startDate,endDate,atendees);
            meetingService.addNewMeeting(meeting);
            list = meetingService.getAllMeetings();
            mav = new ModelAndView("meetings");
            mav.addObject("meetings", list);
        } else {
            Person person = personService.getPersonByName(personService.getAllPeople(),respPerName);
            Meeting meeting = new Meeting(id,name,person,description,category,type,startDate,endDate,atendees);
            meetingService.updateMeeting(meeting);
            list = meetingService.getAllMeetings();
            mav = new ModelAndView("meetings");
            mav.addObject("meetings", list);
        }
        return mav;
    }

    @GetMapping("meeting/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Integer id) throws IOException {
        meetingService.deleteMeeting(id);
        List<Meeting> list = meetingService.getAllMeetings();
        ModelAndView mav = new ModelAndView("meetings");
        mav.addObject("meetings", list);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView searching(
            @RequestParam("name") String name,
            @RequestParam("description") String description
    ) throws IOException {
        List<Meeting> list = meetingService.getMeetingByDescriptionOrName(meetingService.getAllMeetings(),description,name);
        ModelAndView mav = new ModelAndView("meetings");
        mav.addObject("meetings", list);
        return mav;
    }

    @GetMapping("meeting/{id}/atendees")
    public ModelAndView atendees(@PathVariable("id") Integer id) throws IOException {
        List<Person> allPeople = personService.getAllPeople();
        Meeting m = meetingService.getOneMeeting (meetingService.getAllMeetings(), id);
        List<Integer> Ids = meetingService.getAttendeesIdFromMeeting(id);
        List<Person> atendees = personService.getPersonsByIds(personDb.readJsonFilePeople(),Ids);
        ModelAndView mav = new ModelAndView("atendees");
        mav.addObject("people", allPeople);
        mav.addObject("list", atendees);
        mav.addObject("meeting" , m);
        return mav;
    }
    @GetMapping("meeting/{id}/atendee/{atendee_id}/remove")
    public String removeAtendee(@PathVariable("id") Integer id,@PathVariable("atendee_id") Integer atendee_id) throws IOException {
        meetingService.removeAttendee(id,atendee_id);
        return "redirect:/meeting/{id}/atendees";
    }
    @GetMapping("meeting/{id}/addAtendee/")
    public String addAtendee (@PathVariable("id") Integer id,@RequestParam("atendId") Integer atendee_id) throws IOException {
        Person person = personService.getPersonById(personService.getAllPeople(),atendee_id);
        meetingService.addAttendee(person,id);
        return "redirect:/meeting/{id}/atendees";
    }
    @GetMapping("pagalRespPers")
    public ModelAndView chooseResp () throws IOException {
        List<Person> responsiblePersonList = personService.getResponsiblePersonList(personService.getAllPeople());
        ModelAndView mav = new ModelAndView("pagalRespPers");
        mav.addObject("list", responsiblePersonList);
        return mav;
    }
    @GetMapping("/choose")
    public ModelAndView pagalResp(
            @RequestParam("respPers") Integer id
    ) throws IOException {
        List<Meeting> list = meetingService.getMeetingsByResponsiblePerson(meetingService.getAllMeetings(),id);
        ModelAndView mav = new ModelAndView("meetings");
        mav.addObject("meetings", list);
        return mav;
    }
}
