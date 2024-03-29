package lt.bit.spring_web.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.bit.spring_web.data.Meeting;
import lt.bit.spring_web.data.Person;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class MeetingDb {
    private static final String MEETING_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\meeting_spring\\src\\main\\resources\\data\\meeting.json";
    private static final String PERSON_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\meeting_spring\\src\\main\\resources\\data\\people.json";

    private final ObjectMapper mapper = createObjectMapper();

    public void writeToJsonFile(List<Meeting> meetings) {
        try {
            mapper.writeValue(new File(MEETING_FILE_PATH), meetings);
        } catch (IOException e) {
            System.out.println("Failed to write JSON file");
        }
    }

    public List<Meeting> readJsonFile() {
        List<Meeting> meetings = null;
        try {
            meetings = mapper.readValue(new File(MEETING_FILE_PATH), new TypeReference<>() {
            });
        } catch (IOException exception) {
            System.out.println("failed to read file");
        }
        return meetings;
    }



    private ObjectMapper createObjectMapper() {
        final ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        return om;
    }
}
