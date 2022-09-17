package lt.bit.spring_web.data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Meeting {

    public static int nextId = 1;

    private Integer id;
    private String name;
    private Person responsiblePerson;
    private String description;
    private String category;
    private String type;
    private String startDate;
    private String endDate;
    private List<Integer> atendees;

    public Meeting(){this.id = nextId++;}

    public Meeting( String name, Person responsiblePerson, String description, String category, String type, String startDate, String endDate, List<Integer> atendees) {
        this.id = nextId++;
        this.name = name;
        this.responsiblePerson = responsiblePerson;
        this.description = description;
        this.category = category;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.atendees = atendees;
    }

    public Meeting(Integer id, String name, Person responsiblePerson, String description, String category, String type, String startDate, String endDate, List<Integer> atendees) {
        this.id = id;
        this.name = name;
        this.responsiblePerson = responsiblePerson;
        this.description = description;
        this.category = category;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.atendees = atendees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Integer> getAtendees() {
        return atendees;
    }

    public void setAtendees(List<Integer> atendees) {
        this.atendees = atendees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(getId(), meeting.getId()) && Objects.equals(getName(), meeting.getName()) && Objects.equals(getResponsiblePerson(), meeting.getResponsiblePerson()) && Objects.equals(getDescription(), meeting.getDescription()) && Objects.equals(getCategory(), meeting.getCategory()) && Objects.equals(getType(), meeting.getType()) && Objects.equals(getStartDate(), meeting.getStartDate()) && Objects.equals(getEndDate(), meeting.getEndDate()) && Objects.equals(getAtendees(), meeting.getAtendees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getResponsiblePerson(), getDescription(), getCategory(), getType(), getStartDate(), getEndDate(), getAtendees());
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", responsiblePerson=" + responsiblePerson +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", atendees=" + atendees +
                '}';
    }
}
