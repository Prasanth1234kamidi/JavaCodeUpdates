import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * JDK Internals Access Before Java 17
 * Shows how internal APIs were accessible
 */
public class EncapsulationBefore {
    public static void main(String[] args) {
        System.out.println("=== JDK Internals Access Before Java 17 ===\n");
        
        // 1. Unsafe access
        demonstrateUnsafeAccess();
        
        // 2. Internal package access
        demonstrateInternalPackageAccess();
        
        // 3. Reflection on internal classes
        demonstrateInternalReflection();
        
        // 4. Problems with internal API usage
        demonstrateProblems();
    }
    
    @SuppressWarnings("removal")
    private static void demonstrateUnsafeAccess() {
        System.out.println("1. Unsafe API Access (sun.misc.Unsafe):");
        
        try {
            // Get Unsafe instance through reflection
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            Unsafe unsafe = (Unsafe) unsafeField.get(null);
            
            System.out.println("  Unsafe instance obtained: " + (unsafe != null));
            
            if (unsafe != null) {
                // Direct memory allocation
                long address = unsafe.allocateMemory(1024);
                System.out.println("  Allocated memory at: 0x" + Long.toHexString(address));
                
                // Direct memory access
                unsafe.putLong(address, 0x123456789ABCDEFL);
                long value = unsafe.getLong(address);
                System.out.println("  Memory value: 0x" + Long.toHexString(value));
                
                unsafe.freeMemory(address);
                System.out.println("  Memory freed");
            }
            
        } catch (Exception e) {
            System.out.println("  Unsafe access failed: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateInternalPackageAccess() {
        System.out.println("2. Internal Package Access:");
        
        // Before Java 9/17, these were accessible
        System.out.println("  sun.* packages: Historically accessible");
        System.out.println("  com.sun.* packages: Historically accessible");
        System.out.println("  jdk.internal.* packages: Historically accessible");
        
        // Examples of commonly used internal APIs
        System.out.println("  Common internal APIs used:");
        System.out.println("    - sun.misc.Unsafe (memory operations)");
        System.out.println("    - sun.security.* (security internals)");
        System.out.println("    - com.sun.management.* (JVM management)");
        System.out.println("    - sun.nio.* (NIO internals)");
        System.out.println();
    }
    
    private static void demonstrateInternalReflection() {
        System.out.println("3. Reflection on Internal Classes:");
        
        try {
            // Access internal class through reflection
            Class<?> internalClass = Class.forName("sun.misc.Unsafe");
            System.out.println("  Internal class loaded: " + internalClass.getName());
            
            // Get internal methods
            System.out.println("  Internal methods accessible:");
            java.lang.reflect.Method[] methods = internalClass.getDeclaredMethods();
            int count = 0;
            for (java.lang.reflect.Method method : methods) {
                if (count < 5) { // Show first 5 methods
                    System.out.println("    - " + method.getName());
                    count++;
                }
            }
            if (methods.length > 5) {
                System.out.println("    ... and " + (methods.length - 5) + " more methods");
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("  Internal class not found: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateProblems() {
        System.out.println("4. Problems with Internal API Usage:");
        System.out.println("  Security Issues:");
        System.out.println("    - Bypass security managers");
        System.out.println("    - Direct memory manipulation");
        System.out.println("    - Access to sensitive JVM internals");
        
        System.out.println("  Maintenance Issues:");
        System.out.println("    - Internal APIs can change without notice");
        System.out.println("    - No backward compatibility guarantees");
        System.out.println("    - Applications break with JDK updates");
        
        System.out.println("  Performance Issues:");
        System.out.println("    - JVM optimizations may be hindered");
        System.out.println("    - Unpredictable behavior across JVM implementations");
        
        System.out.println("  Portability Issues:");
        System.out.println("    - Code tied to specific JDK implementation");
        System.out.println("    - May not work on different JVMs");
        System.out.println();
        
        System.out.println("Why Strong Encapsulation is Needed:");
        System.out.println("  - Protect JVM integrity");
        System.out.println("  - Enable JDK evolution");
        System.out.println("  - Improve security");
        System.out.println("  - Force use of supported APIs");
    }
}