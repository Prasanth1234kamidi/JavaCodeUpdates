// Before Java 17 - Traditional class approach
import java.util.Objects;

class PersonBefore {
    private final String name;
    private final int age;
    private final String email;

    public PersonBefore(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonBefore person = (PersonBefore) obj;
        return age == person.age && 
               Objects.equals(name, person.name) && 
               Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }

    @Override
    public String toString() {
        return "PersonBefore{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

public class BeforeRecords {
    public static void main(String[] args) {
        System.out.println("=== Before Records (Traditional Class) ===");
        
        PersonBefore person = new PersonBefore("John", 25, "john@email.com");
        
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        System.out.println("ToString: " + person);
        
        PersonBefore person2 = new PersonBefore("John", 25, "john@email.com");
        System.out.println("Equal: " + person.equals(person2));
    }
}