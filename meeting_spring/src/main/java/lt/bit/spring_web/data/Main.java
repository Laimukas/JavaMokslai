package lt.bit.spring_web.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
//
//        List<Meeting> meetings = mapper.readValue(new File(MEETING_FILE_PATH), new TypeReference<>() {
//        });
//        System.out.println(meetings.getClass());

//        Meeting[] meetingList = mapper.readValue(new File(MEETING_FILE_PATH), Meeting[].class);
//        Person[] peopleList = mapper.readValue(new File(PERSON_FILE_PATH), Person[].class);
//        System.out.println("--------------- Meeting List --------------------------");
//        for (Meeting meet : meetings) {
//            System.out.println(meet);
//        }
//        System.out.println("--------------- People List --------------------------");
//        for (Person person:peopleList){
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
    }
}
