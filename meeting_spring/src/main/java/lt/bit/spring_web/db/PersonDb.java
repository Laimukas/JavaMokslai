package lt.bit.spring_web.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.bit.spring_web.data.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersonDb {

    private static final String PERSON_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\meeting_spring\\src\\main\\resources\\data\\people.json";

    private final ObjectMapper mapper = createObjectMapper();

    public void writeToJsonFilePeople(List<Person> list) {
        try {
            mapper.writeValue(new File(PERSON_FILE_PATH), list);
        } catch (IOException e) {
            System.out.println("Failed to write JSON file");
        }
    }

    public List<Person> readJsonFilePeople() {
        List<Person> list = null;
        try {
            list = mapper.readValue(new File(PERSON_FILE_PATH), new TypeReference<>() {
            });
        } catch (IOException exception) {
            System.out.println("failed to read file");
        }
        return list;
    }

    private ObjectMapper createObjectMapper() {
        final ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        return om;
    }
}
