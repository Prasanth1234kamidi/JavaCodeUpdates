/**
 * NullPointerException Before Java 17
 * Shows traditional unhelpful NPE messages
 */
public class NPEBefore {
    public static void main(String[] args) {
        System.out.println("=== NullPointerException Before Java 17 ===\n");
        
        // 1. Traditional NPE messages
        demonstrateTraditionalNPE();
        
        // 2. Complex expression NPEs
        demonstrateComplexNPE();
        
        // 3. Array and method chain NPEs
        demonstrateArrayMethodNPE();
        
        // 4. Debugging challenges
        demonstrateDebuggingChallenges();
    }
    
    private static void demonstrateTraditionalNPE() {
        System.out.println("1. Traditional NPE Messages:");
        
        try {
            String text = null;
            int length = text.length(); // This will throw NPE
        } catch (NullPointerException e) {
            System.out.println("  Traditional NPE message:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Problem: No indication of WHICH variable was null");
        }
        
        try {
            Person person = new Person(null, 25);
            String upperName = person.getName().toUpperCase(); // NPE here
        } catch (NullPointerException e) {
            System.out.println("\n  Object field NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Problem: Doesn't tell us person.getName() returned null");
        }
        System.out.println();
    }
    
    private static void demonstrateComplexNPE() {
        System.out.println("2. Complex Expression NPEs:");
        
        try {
            // Complex chained expression
            Company company = new Company();
            String result = company.getDepartment().getManager().getName().toUpperCase();
        } catch (NullPointerException e) {
            System.out.println("  Complex chain NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Problem: Which part of the chain was null?");
            System.out.println("    Could be: company.getDepartment() = null");
            System.out.println("    Could be: department.getManager() = null");
            System.out.println("    Could be: manager.getName() = null");
        }
        
        try {
            // Array access with method call
            String[] names = {"Alice", null, "Bob"};
            int length = names[1].length(); // NPE on null element
        } catch (NullPointerException e) {
            System.out.println("\n  Array element NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Problem: Doesn't specify which array element was null");
        }
        System.out.println();
    }
    
    private static void demonstrateArrayMethodNPE() {
        System.out.println("3. Array and Method Chain NPEs:");
        
        try {
            // Method returning null in array context
            Person[] people = {new Person("Alice", 30), null, new Person("Bob", 25)};
            String name = people[1].getName(); // NPE
        } catch (NullPointerException e) {
            System.out.println("  Array method NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Problem: Unclear if array element or method result is null");
        }
        
        try {
            // Nested method calls
            DataProcessor processor = new DataProcessor();
            String processed = processor.process(null).trim().toUpperCase();
        } catch (NullPointerException e) {
            System.out.println("\n  Nested method NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Problem: Which method in the chain returned null?");
        }
        System.out.println();
    }
    
    private static void demonstrateDebuggingChallenges() {
        System.out.println("4. Debugging Challenges Before Java 17:");
        
        System.out.println("  Common issues:");
        System.out.println("    - Generic 'null' message provides no context");
        System.out.println("    - Line number helps but not enough for complex expressions");
        System.out.println("    - Developers need to add logging/debugging");
        System.out.println("    - Time-consuming to identify exact null reference");
        
        System.out.println("\n  Typical debugging process:");
        System.out.println("    1. Look at line number in stack trace");
        System.out.println("    2. Examine all variables in that line");
        System.out.println("    3. Add null checks or logging");
        System.out.println("    4. Reproduce the issue");
        System.out.println("    5. Repeat until null source is found");
        
        System.out.println("\n  Example debugging code needed:");
        System.out.println("    if (company == null) System.out.println(\"company is null\");");
        System.out.println("    if (company.getDepartment() == null) System.out.println(\"department is null\");");
        System.out.println("    // ... and so on for each part of the chain");
    }
    
    // Helper classes for demonstration
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
    }
    
    static class Company {
        public Department getDepartment() { return null; } // Simulates null return
    }
    
    static class Department {
        public Manager getManager() { return null; }
    }
    
    static class Manager {
        public String getName() { return null; }
    }
    
    static class DataProcessor {
        public String process(String input) { return null; } // Simulates null return
    }
}