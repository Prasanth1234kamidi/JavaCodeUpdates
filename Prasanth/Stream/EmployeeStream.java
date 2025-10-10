package Stream;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    int salary;
    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class EmployeeStream {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Prashanth", 60000),
            new Employee("Ravi", 40000),
            new Employee("Raj", 70000),
            new Employee("Sita", 30000)
        );

        employees.stream()
                 .filter(emp -> emp.salary > 50000) // Predicate
                 .map(emp -> emp.name.toUpperCase()) // Function
                 .forEach(System.out::println);      // Consumer
    }
}
