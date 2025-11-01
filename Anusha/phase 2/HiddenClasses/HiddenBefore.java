/**
 * Hidden Classes Before Java 17
 * Shows traditional class loading limitations
 */
public class HiddenBefore {
    public static void main(String[] args) {
        System.out.println("=== Class Loading Before Java 17 ===\n");
        
        // 1. Traditional class loading
        demonstrateTraditionalClassLoading();
        
        // 2. Dynamic class generation issues
        demonstrateDynamicClassIssues();
        
        // 3. Memory and security concerns
        demonstrateMemorySecurityConcerns();
        
        // 4. Limitations
        demonstrateLimitations();
    }
    
    private static void demonstrateTraditionalClassLoading() {
        System.out.println("1. Traditional Class Loading:");
        
        System.out.println("  Standard class loading process:");
        System.out.println("    - Classes loaded by ClassLoader");
        System.out.println("    - Stored in ClassLoader registry");
        System.out.println("    - Discoverable by name");
        System.out.println("    - Accessible via reflection");
        
        // Demonstrate normal class access
        Class<?> thisClass = HiddenBefore.class;
        System.out.println("\n  Current class info:");
        System.out.println("    Name: " + thisClass.getName());
        System.out.println("    Discoverable: " + isDiscoverable(thisClass.getName()));
        System.out.println("    ClassLoader: " + thisClass.getClassLoader());
        System.out.println();
    }
    
    private static void demonstrateDynamicClassIssues() {
        System.out.println("2. Dynamic Class Generation Issues:");
        
        System.out.println("  Problems with dynamic classes:");
        System.out.println("    - All classes remain in memory");
        System.out.println("    - ClassLoader holds references");
        System.out.println("    - Cannot be garbage collected easily");
        System.out.println("    - Name conflicts possible");
        
        System.out.println("\n  Framework challenges:");
        System.out.println("    - Proxy classes accumulate");
        System.out.println("    - Lambda implementations persist");
        System.out.println("    - Code generation creates permanent classes");
        System.out.println("    - Memory leaks in long-running applications");
        
        // Simulate the problem
        System.out.println("\n  Simulating dynamic class accumulation:");
        for (int i = 0; i < 5; i++) {
            String className = "DynamicClass" + i;
            System.out.println("    Generated: " + className + " (stays in memory)");
        }
        System.out.println();
    }
    
    private static void demonstrateMemorySecurityConcerns() {
        System.out.println("3. Memory and Security Concerns:");
        
        System.out.println("  Memory issues:");
        System.out.println("    - Classes never unloaded (except with ClassLoader)");
        System.out.println("    - Metadata overhead accumulates");
        System.out.println("    - PermGen/Metaspace pressure");
        System.out.println("    - Long-running applications suffer");
        
        System.out.println("\n  Security concerns:");
        System.out.println("    - All classes discoverable by name");
        System.out.println("    - Reflection can access any class");
        System.out.println("    - No true isolation");
        System.out.println("    - Framework internals exposed");
        
        System.out.println("\n  Example security issue:");
        System.out.println("    Class.forName(\"com.framework.InternalClass\")");
        System.out.println("    // Can access framework internals!");
        System.out.println();
    }
    
    private static void demonstrateLimitations() {
        System.out.println("4. Limitations Before Java 17:");
        
        System.out.println("  Framework developers face:");
        System.out.println("    - Memory leaks from generated classes");
        System.out.println("    - Security exposure of internal classes");
        System.out.println("    - Complex ClassLoader management");
        System.out.println("    - Performance degradation over time");
        
        System.out.println("\n  Workarounds required:");
        System.out.println("    - Custom ClassLoaders for isolation");
        System.out.println("    - Manual class unloading strategies");
        System.out.println("    - Obfuscation for security");
        System.out.println("    - Restart applications to clear memory");
        
        System.out.println("\n  Impact on applications:");
        System.out.println("    - Frameworks like Spring, Hibernate affected");
        System.out.println("    - Dynamic languages (Groovy, JRuby) suffer");
        System.out.println("    - Code generation libraries problematic");
        System.out.println("    - Long-running servers need restarts");
        
        // Show current memory usage
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("\n  Current memory usage: " + (usedMemory / 1024 / 1024) + " MB");
        System.out.println("  (All loaded classes remain in memory)");
    }
    
    private static boolean isDiscoverable(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}