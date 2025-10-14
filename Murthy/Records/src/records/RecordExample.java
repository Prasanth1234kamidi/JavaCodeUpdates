package records;

public class RecordExample {

record Person(String name, int age) {
        
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative!");
            }
        }
        
        public String greet() {
            return "Hello, my name is " + name + " and I am " + age + " years old.";
        }
    }

	public static void main(String[] args) {
        Person p1 = new Person("Murthy", 25);
        Person p2 = new Person("Raju", 30);

        System.out.println("Name: " + p1.name());
        System.out.println("Age: " + p1.age());

        System.out.println(p1.greet());
        System.out.println(p2.greet());
        
        System.out.println("Person 1 Details: " + p1);
        System.out.println("Person 2 Details: " + p2);

        System.out.println("Are both persons same? " + p1.equals(p2));

	}

}
