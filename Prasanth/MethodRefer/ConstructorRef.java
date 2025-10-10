package MethodRefer;

import java.util.function.Supplier;

class Employee {
    public Employee() {
        System.out.println("Employee object created");
    }
}

public class ConstructorRef {
    public static void main(String[] args) {
        // Lambda
        Supplier<Employee> emp1 = () -> new Employee();

        // Constructor Reference
        Supplier<Employee> emp2 = Employee::new;

        emp1.get();
        emp2.get();
    }
}
