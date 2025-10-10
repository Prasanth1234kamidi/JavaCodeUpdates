package EmployeeSystem;

import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    int salary;

    Employee(int id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ") - " + salary;
    }
}
