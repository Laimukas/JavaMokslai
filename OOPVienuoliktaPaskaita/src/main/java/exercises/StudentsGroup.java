package exercises;

public class StudentsGroup {

    private String id;
    private int studentsCount;

    public StudentsGroup(String id, int studentsCount) {
        this.id = id;
        this.studentsCount = studentsCount;
    }

    public String getId() {
        return id;
    }

    public int getStudentsCount() {
        return studentsCount;
    }
}
