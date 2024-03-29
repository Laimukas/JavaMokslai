package lt.bit.spring_web.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.bit.spring_web.db.MeetingDb;
import lt.bit.spring_web.db.PersonDb;
import lt.bit.spring_web.service.MeetingService;
import lt.bit.spring_web.service.PersonService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String MEETING_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\meeting_spring\\src\\main\\resources\\data\\meeting.json";
    private static final String PERSON_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\meeting_spring\\src\\main\\resources\\data\\people.json";

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        final MeetingDb meetingDb = new MeetingDb();
        final PersonDb personDb = new PersonDb();

        final MeetingService meetingService = new MeetingService(meetingDb);
        final PersonService personService = new PersonService(personDb);
        ArrayList<Meeting> meetings = mapper.readValue(new File(MEETING_FILE_PATH), new TypeReference<>() {
        });
//        System.out.println(meetings);

//        Meeting[] meetingList = mapper.readValue(new File(MEETING_FILE_PATH), Meeting[].class);
//        Person[] peopleList = mapper.readValue(new File(PERSON_FILE_PATH), Person[].class);
//        System.out.println("--------------- Meeting List --------------------------");
//        for (Meeting meet : meetings) {
//            System.out.println(meet);
//        }
//        System.out.println("--------------- People List --------------------------");
//        for (Person person : peopleList) {
//            System.out.println(person);
//        }
//
////        System.out.println(peopleList[10]);
//        List<Integer> dalyviai = new ArrayList<>();
//        dalyviai.add(16);
//        dalyviai.add(20);
//        Meeting[] naujasListas = new Meeting[3];
//        for (int i = 0;i<= naujasListas.length;i++){
//            if (meetingList.length>=i) {
//                naujasListas[i] = meetingList[i];
//            }else{
//
//            }
//        }
//        System.out.println("printinu nauja lista: "+naujasListas);
//
//        Meeting meetas = new Meeting("Coding",peopleList[0],"Aptarimas","CodeMonkey","InPerson","2022-11-04 10:00","2022-11-04 11:00",null);
//        meetas.setAtendees(dalyviai);
//        System.out.println(meetas);
//
//         naujasListas[3] = meetas;
//        System.out.println(naujasListas);
//
//        System.out.println("--------------- Irasinejam JSON faila ------------------");
//        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(MEETING_FILE_PATH),naujasListas);
//        System.out.println("Done");

//        }
//        System.out.println("------------------Tikrinam ar duoda respPersonu lista ---------------");
//        List<Person> list = personService.getResponsiblePersonList(personService.getAllPeople());
//        for (Person person:list){
//            System.out.println(person.getPrname());
//        }
        System.out.println("------------------Tikrinam ar duoda AtendeeId lista ---------------");
        List<Integer> list = meetingService.getAttendeesIdFromMeeting(1);
        List<Person> atendees = personService.getPersonsByIds(personDb.readJsonFilePeople(),list);
        for (Person person:atendees){
            System.out.println(person.getPrname());
        }


    }
}
