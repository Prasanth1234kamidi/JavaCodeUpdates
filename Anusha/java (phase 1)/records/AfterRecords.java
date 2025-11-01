// Java 17 - Records approach
record PersonRecord(String name, int age, String email) {
    // Compact constructor for validation
    public PersonRecord {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
    }
    
    // Custom methods can still be added
    public boolean isAdult() {
        return age >= 18;
    }
}

public class AfterRecords {
    public static void main(String[] args) {
        System.out.println("=== After Records (Java 17) ===");
        
        PersonRecord person = new PersonRecord("John", 25, "john@email.com");
        
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        System.out.println("Email: " + person.email());
        System.out.println("Is Adult: " + person.isAdult());
        System.out.println("ToString: " + person);
        
        PersonRecord person2 = new PersonRecord("John", 25, "john@email.com");
        System.out.println("Equal: " + person.equals(person2));
    }
}