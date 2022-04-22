package lt.bit.Task2;

public class Lecturer extends Person {

    private String specialization;
    private double salary;

    public Lecturer(String name, String address, String specialization, double salary){
        super(name, address);
        this.specialization = specialization;
        this.salary = salary;
    }

    public String getSpecialization(){
        return specialization;
    }

    public double getSalary(){
        return salary;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String toString(){
        return String.format("Vardas: %s, adresas: %s, specelizacija: %s, atlyginimas: %.2f",
                super.name, super.address, specialization, salary);
    }
}
