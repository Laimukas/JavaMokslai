package lt.bit.spring_web.service;

import lt.bit.spring_web.data.Person;
import lt.bit.spring_web.db.MeetingDb;
import lt.bit.spring_web.db.PersonDb;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

//@Service
//@AllArgsConstructor
public class PersonService {

    private final PersonDb personDb;

    public PersonService(PersonDb personDb) {
        this.personDb = personDb;
    }

    public List<Person> getAllPeople() {
        return personDb.readJsonFilePeople();
    }
    public Person addNewPerson(Person person) {
        List<Person> list = getAllPeople();
        list.add(person);
        personDb.writeToJsonFilePeople(list);
        return person;
    }
    public Person getOnePerson(List<Person> list,Integer id) {
        if (id == null) {
            throw new NullPointerException("You have to get id for person");
        }
        for (Person person : list) {
            if (id.equals(person.getId())) {
                System.out.println("Person we are looking for: " + person);
                return person;
            }
        }
        throw new IllegalArgumentException("Person not found");
    }
    public List<Person> getPersonByName(List<Person> list, String name) {
        List<Person> sortas = new ArrayList<>();
        for (Person person : list) {
            if (person.getPrname().toLowerCase().contains(name.toLowerCase())) {
                sortas.add(person);
            }
        }
        return sortas;
    }
    public Person getPersonById(List<Person> list, Integer id) {
        Person sortas = new Person();
        for (Person person : list) {
            if (person.getId()==(id)) {
                sortas=person;
            }
        }
        return sortas;
    }
    public List<Person> getPersonsByIds(List<Person> list, List<Integer> Ids) {
        List<Person> sortas = new ArrayList<>();
        for (Person person : list) {
            Integer perId = person.getId();
            for (Integer id : Ids)
            if ((id).equals(perId)) {
                sortas.add(person);
            }
        }
        return sortas;
    }
    public List<Person> getPersonByStatus(List<Person> list, String status) {
        List<Person> sortas = new ArrayList<>();
        for (Person person : list) {
            if (person.getStatus().toLowerCase().contains(status.toLowerCase())) {
                sortas.add(person);
            }
        }
        return sortas;
    }
    public List<Person> getResponsiblePersonList(List<Person> list) {
        List<Person> sortas = new ArrayList<>();
        for (Person person : list) {
            if (person.getStatus().toLowerCase().equals("responsiblePerson".toLowerCase())) {
                sortas.add(person);
            }
        }
        return sortas;
    }
}
