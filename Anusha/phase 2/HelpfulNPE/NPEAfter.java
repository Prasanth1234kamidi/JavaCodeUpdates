/**
 * Helpful NullPointerException After Java 17
 * Shows enhanced NPE messages with precise information
 */
public class NPEAfter {
    public static void main(String[] args) {
        System.out.println("=== Helpful NullPointerException After Java 17 ===\n");
        
        // Note: Run with -XX:+ShowCodeDetailsInExceptionMessages for full effect
        System.out.println("Note: For best results, run with:");
        System.out.println("java -XX:+ShowCodeDetailsInExceptionMessages NPEAfter\n");
        
        // 1. Enhanced NPE messages
        demonstrateEnhancedNPE();
        
        // 2. Complex expression analysis
        demonstrateComplexAnalysis();
        
        // 3. Array and method precision
        demonstrateArrayMethodPrecision();
        
        // 4. Benefits for debugging
        demonstrateDebuggingBenefits();
    }
    
    private static void demonstrateEnhancedNPE() {
        System.out.println("1. Enhanced NPE Messages (Java 14+, Default in Java 17):");
        
        try {
            String text = null;
            int length = text.length(); // Enhanced NPE message
        } catch (NullPointerException e) {
            System.out.println("  Enhanced NPE message:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Clearly shows 'text' is null");
        }
        
        try {
            Person person = new Person(null, 25);
            String upperName = person.getName().toUpperCase(); // Enhanced NPE
        } catch (NullPointerException e) {
            System.out.println("\n  Method return NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Shows person.getName() returned null");
        }
        System.out.println();
    }
    
    private static void demonstrateComplexAnalysis() {
        System.out.println("2. Complex Expression Analysis:");
        
        try {
            // Complex chained expression with precise error location
            Company company = new Company();
            String result = company.getDepartment().getManager().getName().toUpperCase();
        } catch (NullPointerException e) {
            System.out.println("  Complex chain NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Pinpoints exactly which method returned null");
        }
        
        try {
            // Array access with enhanced information
            String[] names = {"Alice", null, "Bob"};
            int length = names[1].length(); // Precise array element info
        } catch (NullPointerException e) {
            System.out.println("\n  Array element NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Shows exactly which array element is null");
        }
        System.out.println();
    }
    
    private static void demonstrateArrayMethodPrecision() {
        System.out.println("3. Array and Method Precision:");
        
        try {
            // Method call on null array element
            Person[] people = {new Person("Alice", 30), null, new Person("Bob", 25)};
            String name = people[1].getName(); // Precise error
        } catch (NullPointerException e) {
            System.out.println("  Array method NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Clearly identifies people[1] is null");
        }
        
        try {
            // Nested method calls with precision
            DataProcessor processor = new DataProcessor();
            String processed = processor.process(null).trim().toUpperCase();
        } catch (NullPointerException e) {
            System.out.println("\n  Nested method NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Shows exactly which method returned null");
        }
        
        try {
            // Field access precision
            Customer customer = new Customer();
            String email = customer.contact.email.toUpperCase();
        } catch (NullPointerException e) {
            System.out.println("\n  Field access NPE:");
            System.out.println("    " + e.getMessage());
            System.out.println("    Benefit: Identifies which field in the chain is null");
        }
        System.out.println();
    }
    
    private static void demonstrateDebuggingBenefits() {
        System.out.println("4. Debugging Benefits in Java 17+:");
        
        System.out.println("  Enhanced NPE advantages:");
        System.out.println("    ✓ Immediate identification of null reference");
        System.out.println("    ✓ No need for additional logging");
        System.out.println("    ✓ Faster debugging and development");
        System.out.println("    ✓ Better error messages in production");
        
        System.out.println("\n  Message format improvements:");
        System.out.println("    Before: 'null' (unhelpful)");
        System.out.println("    After:  'Cannot invoke \"String.length()\" because \"text\" is null'");
        System.out.println("    After:  'Cannot read field \"email\" because \"customer.contact\" is null'");
        
        System.out.println("\n  Development workflow improvement:");
        System.out.println("    1. Exception occurs with precise message");
        System.out.println("    2. Immediately know which variable/expression is null");
        System.out.println("    3. Fix the issue directly");
        System.out.println("    4. No debugging session needed!");
        
        // Demonstrate various NPE scenarios
        demonstrateVariousScenarios();
    }
    
    private static void demonstrateVariousScenarios() {
        System.out.println("\n  Various Enhanced NPE Scenarios:");
        
        // Scenario 1: Method parameter
        try {
            processString(null);
        } catch (NullPointerException e) {
            System.out.println("    Parameter NPE: " + e.getMessage());
        }
        
        // Scenario 2: Return value
        try {
            String result = getNullString().substring(0, 5);
        } catch (NullPointerException e) {
            System.out.println("    Return value NPE: " + e.getMessage());
        }
        
        // Scenario 3: Array assignment
        try {
            String[] array = new String[3];
            array[0] = "test";
            int len = array[1].length(); // null element
        } catch (NullPointerException e) {
            System.out.println("    Array element NPE: " + e.getMessage());
        }
        
        System.out.println("\n  Result: Debugging time reduced by 80%+ with helpful NPEs!");
    }
    
    private static void processString(String input) {
        input.toUpperCase(); // Will throw enhanced NPE if input is null
    }
    
    private static String getNullString() {
        return null; // Simulates method returning null
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
    
    static class Customer {
        public Contact contact = null; // Null field for demonstration
    }
    
    static class Contact {
        public String email = null;
    }
}