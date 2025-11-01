public class EncapsulationDemo {
    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demo ===");
        
        System.out.println("Testing safe memory operations:");
        EncapsulationAfter.safeMemoryExample();
        
        System.out.println("\nTesting standard XML parser:");
        EncapsulationAfter.standardParserExample();
        
        System.out.println("\nTesting safe reflection:");
        EncapsulationAfter.safeReflectionExample();
        
        System.out.println("\nTesting problematic internal APIs:");
        EncapsulationBefore.unsafeExample();
    }
}

// Run: javac *.java && java EncapsulationDemo