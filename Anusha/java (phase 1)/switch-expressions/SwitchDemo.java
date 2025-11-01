public class SwitchDemo {
    public static void main(String[] args) {
        System.out.println("=== Switch Expressions Comparison Demo ===");
        
        System.out.println("\n--- Before Switch Expressions ---");
        BeforeSwitchExpressions.main(args);
        
        System.out.println("\n--- After Switch Expressions (Java 17) ---");
        AfterSwitchExpressions.main(args);
    }
}

// Run: javac *.java && java SwitchDemo