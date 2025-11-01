// Before Java 17 - Access to internal APIs (DEPRECATED/REMOVED)
import java.lang.reflect.Field;

class EncapsulationBefore {
    
    // This would work in older Java versions but is problematic
    public static void unsafeExample() {
        System.out.println("Internal APIs are no longer accessible in Java 17+");
        System.out.println("This demonstrates why encapsulation was needed.");
    }
}