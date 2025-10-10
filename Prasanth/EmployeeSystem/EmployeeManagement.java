package EmployeeSystem;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class EmployeeManagement {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "Prashanth", "IT", 60000),
            new Employee(2, "Raj", "HR", 40000),
            new Employee(3, "Lakshmi", "IT", 70000),
            new Employee(4, "Sita", "Finance", 50000),
            new Employee(5, "Sai", "HR", 55000)
        );

        // 1. Filter salary > 50k
        System.out.println("Employees with salary > 50k:");
        employees.stream()
                 .filter(emp -> emp.salary > 50000)
                 .forEach(System.out::println);

        // 2. Group by department
        Map<String, List<Employee>> groupByDept = employees.stream()
            .collect(Collectors.groupingBy(emp -> emp.department));

        System.out.println("\nEmployees grouped by department:");
        groupByDept.forEach((dept, emps) -> System.out.println(dept + ": " + emps));

        // 3. Average salary per department
        Map<String, Double> avgSalary = employees.stream()
            .collect(Collectors.groupingBy(
                emp -> emp.department,
                Collectors.averagingInt(emp -> emp.salary)
            ));

        System.out.println("\nAverage salary per department:");
        avgSalary.forEach((dept, avg) -> System.out.println(dept + ": " + avg));

        // 4. Employee names in uppercase
        List<String> namesUpper = employees.stream()
                                           .map(emp -> emp.name.toUpperCase())
                                           .collect(Collectors.toList());
        System.out.println("\nEmployee names in uppercase: " + namesUpper);

        // 5. Handle missing employee safely with Optional
        Optional<Employee> empOpt = employees.stream()
                                             .filter(emp -> emp.id == 10)
                                             .findFirst();

        Employee emp = empOpt.orElseGet(() -> new Employee(0, "Default Employee", "None", 0));
        System.out.println("\nEmployee found or default: " + emp);

        // 6. Parallel Stream: sum of all salaries
        int totalSalary = employees.parallelStream()
                                   .mapToInt(emp2 -> emp2.salary)
                                   .sum();
        System.out.println("\nTotal Salary (Parallel Stream): " + totalSalary);
    }
}
