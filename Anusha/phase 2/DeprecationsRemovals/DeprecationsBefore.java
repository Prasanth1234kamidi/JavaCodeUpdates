// import java.applet.Applet; // Removed in Java 17+
// import java.security.SecurityManager; // Removed in Java 17+

/**
 * Deprecations Before Java 17
 * Shows APIs that were deprecated but still available
 */
public class DeprecationsBefore {
    public static void main(String[] args) {
        System.out.println("=== Deprecations Before Java 17 ===\n");
        
        // 1. Security Manager (deprecated in Java 17)
        demonstrateSecurityManager();
        
        // 2. Applet API (deprecated in Java 9)
        demonstrateAppletAPI();
        
        // 3. RMI Activation (deprecated in Java 15)
        demonstrateRMIActivation();
        
        // 4. Finalization (deprecated warnings)
        demonstrateFinalization();
    }
    
    private static void demonstrateSecurityManager() {
        System.out.println("1. Security Manager (removed in Java 17+):");
        
        try {
            Object sm = System.getSecurityManager();
            System.out.println("  Current Security Manager: " + (sm != null ? "present" : "null"));
        } catch (Exception e) {
            System.out.println("  Security Manager API: " + e.getMessage());
        }
        
        System.out.println("  Status: SecurityManager class removed in Java 17+");
        System.out.println("  Before Java 17: Could install custom security managers");
        System.out.println("  After Java 17: Use OS-level security, containers, or JVM flags");
        System.out.println();
    }
    
    private static void demonstrateAppletAPI() {
        System.out.println("2. Applet API (removed in Java 17+):");
        
        try {
            Class.forName("java.applet.Applet");
            System.out.println("  Applet class: Still available");
        } catch (ClassNotFoundException e) {
            System.out.println("  Applet class: Removed from JDK");
        }
        System.out.println("  Browser plugin support: removed");
        System.out.println("  JNLP Web Start: removed");
        System.out.println("  Alternative: Use modern web technologies");
        System.out.println();
    }
    
    private static void demonstrateRMIActivation() {
        System.out.println("3. RMI Activation (deprecated in Java 15):");
        
        try {
            // RMI Activation classes were available
            Class.forName("java.rmi.activation.Activatable");
            System.out.println("  RMI Activation classes: available but deprecated");
        } catch (ClassNotFoundException e) {
            System.out.println("  RMI Activation classes: not found");
        }
        System.out.println();
    }
    
    private static void demonstrateFinalization() {
        System.out.println("4. Finalization (deprecated warnings):");
        
        // Object with finalize method
        class DeprecatedFinalizer {
            @Override
            @SuppressWarnings("deprecation")
            protected void finalize() throws Throwable {
                System.out.println("    Finalizer called (deprecated pattern)");
                super.finalize();
            }
        }
        
        DeprecatedFinalizer obj = new DeprecatedFinalizer();
        obj = null; // Make eligible for GC
        
        System.out.println("  finalize() method: deprecated but functional");
        System.out.println("  Recommendation: Use try-with-resources or Cleaner API");
        System.out.println();
    }
}