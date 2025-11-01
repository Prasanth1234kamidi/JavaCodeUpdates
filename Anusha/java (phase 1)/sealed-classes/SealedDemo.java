public class SealedDemo {
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes Comparison Demo ===");
        
        System.out.println("\n--- Before Sealed Classes ---");
        BeforeSealed.main(args);
        
        System.out.println("\n--- After Sealed Classes (Java 17) ---");
        AfterSealed.main(args);
    }
}