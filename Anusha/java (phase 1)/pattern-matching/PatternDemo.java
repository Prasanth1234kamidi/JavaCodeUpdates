public class PatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching Comparison Demo ===");
        
        System.out.println("\n--- Before Pattern Matching ---");
        BeforePatternMatching.main(args);
        
        System.out.println("\n--- After Pattern Matching (Java 17) ---");
        AfterPatternMatching.main(args);
    }
}

// Run: javac *.java && java PatternDemo