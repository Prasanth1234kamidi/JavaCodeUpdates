// Base class
abstract class Employee {
    String name;
    Employee(String name) { this.name = name; }
}

// Subclasses
class PermanentEmployee extends Employee {
    double salary;
    PermanentEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }
}

class ContractEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;
    ContractEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
}

class Intern extends Employee {
    double stipend;
    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
}

public class Patternmatching17 {
    static String process(Employee emp) {
        return switch (emp) {
            case PermanentEmployee p -> "Permanent: " + p.name + " earns salary ₹" + p.salary;
            case ContractEmployee c -> "Contract: " + c.name + " earns ₹" + (c.hourlyRate * c.hoursWorked);
            case Intern i -> "Intern: " + i.name + " gets stipend ₹" + i.stipend;
            case null -> "No employee data";
            default -> "Unknown employee type";
        };
    }

    public static void main(String[] args) {
        Employee e1 = new PermanentEmployee("Ravi", 50000);
        Employee e2 = new ContractEmployee("Sita", 1000, 20);
        Employee e3 = new Intern("Arjun", 5000);

        System.out.println(process(e1));
        System.out.println(process(e2));
        System.out.println(process(e3));
        System.out.println(process(null));
    }
}
