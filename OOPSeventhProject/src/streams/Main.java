package streams;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> zodziai = List.of("abc", "aabc", "aade", "bdes", "kasd", "abcde");

        zodziai.stream()
                .filter(zodis -> zodis.startsWith("a"))
                .filter(zodis -> zodis.endsWith("c"))
                .forEach(zodis -> System.out.println(zodis));

        Employee employee = new Employee("Petras", 1000, 4);
        Employee employee1 = new Employee("Ieva", 2000, 6);
        Employee employee2 = new Employee("Azuolas", 2200, 7);

        List<Employee> employeeList = List.of(employee, employee1, employee2);

        List<Employee> darbuotojaiKurieGavoPakelima = employeeList.stream()
                .filter(e -> e.getWorksInCompany() >= 5)
                .peek(e -> e.increaseSalary(200))
                .collect(Collectors.toList());

//        ArrayList<Employee> kitasListas = new ArrayList<>();
//        for(Employee e : employeeList){
//            if(e.getWorksInCompany() >= 5){
//                e.increaseSalary(200);
//                kitasListas.add(e);
//            }
//        }
//        kitasListas.forEach(d -> System.out.println(d));

        darbuotojaiKurieGavoPakelima.forEach(d -> System.out.println(d));
    }
}
