public class RecordDemo {
    public static void main(String[] args) {
        System.out.println("=== Records Comparison Demo ===");
        
        System.out.println("\n--- Before Records (Traditional Class) ---");
        BeforeRecords.main(args);
        
        System.out.println("\n--- After Records (Java 17) ---");
        AfterRecords.main(args);
    }
}