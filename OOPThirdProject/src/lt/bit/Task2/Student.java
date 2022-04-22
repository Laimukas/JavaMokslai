package lt.bit.Task2;

import lombok.*;

@Getter
@Setter
public class Student extends Person{

    private TypeOfStudy typeOfStudy;
    private int yearOfStudy;
    private double studyPrice;

    public Student(String name, String address, TypeOfStudy typeOfStudy, int yearOfStudy, double studyPrice) {
        super(name, address);
        this.typeOfStudy = typeOfStudy;
        this.yearOfStudy = yearOfStudy;
        this.studyPrice = studyPrice;
    }

    public String toString(){
        return String.format("Vardas: %s, adresas: %s, studiju tipas: %s, studiju metai: %d, kaina studiju: %.2f",
                super.name, super.address, typeOfStudy, yearOfStudy, studyPrice);
    }
}
