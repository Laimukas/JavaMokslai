package streams;

public class Employee {

    String name;
    double salary;
    // in years
    int worksInCompany;

    public Employee(String name, double salary, int worksInCompany) {
        this.name = name;
        this.salary = salary;
        this.worksInCompany = worksInCompany;
    }

    public void increaseSalary(double money) {
        salary = salary + money;
    }

    @Override
    public String toString() {
        return String.format("Darbuotojo vardas: %s, atlyginimas: %.2f, dirba kompanijoje: %d", name, salary, worksInCompany);
    }

    public int getWorksInCompany() {
        return worksInCompany;
    }
}
