import java.lang.ref.Cleaner;

/**
 * Deprecations After Java 17
 * Shows removed APIs and modern alternatives
 */
public class DeprecationsAfter {
    private static final Cleaner cleaner = Cleaner.create();
    
    public static void main(String[] args) {
        System.out.println("=== Deprecations After Java 17 ===\n");
        
        // 1. Security Manager removal
        demonstrateSecurityManagerRemoval();
        
        // 2. Modern alternatives to deprecated APIs
        demonstrateModernAlternatives();
        
        // 3. Cleaner API instead of finalization
        demonstrateCleanerAPI();
        
        // 4. Module system enforcement
        demonstrateModuleEnforcement();
    }
    
    private static void demonstrateSecurityManagerRemoval() {
        System.out.println("1. Security Manager (removed/restricted in Java 17+):");
        
        try {
            SecurityManager sm = System.getSecurityManager();
            System.out.println("  Current Security Manager: " + (sm != null ? "present" : "null"));
            
            // Attempting to set Security Manager may throw UnsupportedOperationException
            System.setSecurityManager(null);
            System.out.println("  Security Manager operations: restricted");
        } catch (UnsupportedOperationException e) {
            System.out.println("  Security Manager: " + e.getMessage());
        }
        
        System.out.println("  Alternative: Use OS-level security, containers, or JVM flags");
        System.out.println();
    }
    
    private static void demonstrateModernAlternatives() {
        System.out.println("2. Modern Alternatives to Deprecated APIs:");
        
        // Instead of Applets - use modern web technologies
        System.out.println("  Instead of Applets:");
        System.out.println("    - Use WebAssembly (WASM)");
        System.out.println("    - Use JavaScript frameworks");
        System.out.println("    - Use Progressive Web Apps (PWA)");
        
        // Instead of RMI Activation - use modern distributed systems
        System.out.println("  Instead of RMI Activation:");
        System.out.println("    - Use REST APIs");
        System.out.println("    - Use gRPC");
        System.out.println("    - Use message queues (Kafka, RabbitMQ)");
        System.out.println();
    }
    
    private static void demonstrateCleanerAPI() {
        System.out.println("3. Cleaner API (modern alternative to finalization):");
        
        // Modern resource management
        class ModernResource implements AutoCloseable {
            private final String name;
            private final Cleaner.Cleanable cleanable;
            
            public ModernResource(String name) {
                this.name = name;
                // Register cleanup action
                this.cleanable = cleaner.register(this, new CleanupAction(name));
                System.out.println("    Resource created: " + name);
            }
            
            @Override
            public void close() {
                cleanable.clean();
                System.out.println("    Resource closed explicitly: " + name);
            }
            
            // Cleanup action (must not reference the resource object)
            static class CleanupAction implements Runnable {
                private final String resourceName;
                
                CleanupAction(String resourceName) {
                    this.resourceName = resourceName;
                }
                
                @Override
                public void run() {
                    System.out.println("    Cleanup performed for: " + resourceName);
                }
            }
        }
        
        // Demonstrate proper resource management
        try (ModernResource resource = new ModernResource("DatabaseConnection")) {
            System.out.println("    Using resource...");
        } // Automatic cleanup via try-with-resources
        
        System.out.println("  Benefits: Deterministic cleanup, no GC dependency");
        System.out.println();
    }
    
    private static void demonstrateModuleEnforcement() {
        System.out.println("4. Strong Encapsulation Enforcement:");
        
        // Check module system
        Module currentModule = DeprecationsAfter.class.getModule();
        System.out.println("  Current module: " + currentModule.getName());
        System.out.println("  Module system active: " + currentModule.isNamed());
        
        // Internal APIs are now strongly encapsulated
        System.out.println("  Internal JDK APIs: strongly encapsulated");
        System.out.println("  sun.* packages: access restricted");
        System.out.println("  Use --add-opens for legacy compatibility (not recommended)");
        
        // Show available modules
        System.out.println("  Available system modules:");
        ModuleLayer.boot().modules().stream()
            .map(Module::getName)
            .filter(name -> name.startsWith("java."))
            .sorted()
            .limit(5)
            .forEach(name -> System.out.println("    - " + name));
        System.out.println();
    }
}