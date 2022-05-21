package exercises;


import java.util.List;

public class EmployeeWrapper {

    private String id;
    private String pareigos;
    private int stazas;
    private Person person;
    private List<StudentsGroup> studentsGroupList;

    public EmployeeWrapper(String id, String pareigos, int stazas, Person person, List<StudentsGroup> studentsGroupList) {
        this.id = id;
        this.pareigos = pareigos;
        this.stazas = stazas;
        this.person = person;
        this.studentsGroupList = studentsGroupList;
    }

    public String getId() {
        return id;
    }

    public String getPareigos() {
        return pareigos;
    }

    public int getStazas() {
        return stazas;
    }

    public Person getPerson() {
        return person;
    }

    public List<StudentsGroup> getStudentsGroupList() {
        return studentsGroupList;
    }
}
