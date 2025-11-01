import java.util.Objects; // ✅ Required for Objects.hash

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class Beforerecord {
    public static void main(String[] args) {
        Person p = new Person("Alice", 25);
        System.out.println(p); // Person{name='Alice', age=25}
           System.out.println(p.getName()); // Alice
        System.out.println(p.getAge());  // 25
    }
}
