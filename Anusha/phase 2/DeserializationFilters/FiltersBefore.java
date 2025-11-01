import java.io.*;

/**
 * Deserialization Before Java 17
 * Shows traditional deserialization without context-specific filters
 */
public class FiltersBefore {
    public static void main(String[] args) {
        System.out.println("=== Deserialization Before Java 17 ===\n");
        
        // 1. Traditional deserialization
        demonstrateTraditionalDeserialization();
        
        // 2. Global filter (Java 9+)
        demonstrateGlobalFilter();
        
        // 3. Security vulnerabilities
        demonstrateSecurityIssues();
        
        // 4. Limitations
        demonstrateLimitations();
    }
    
    private static void demonstrateTraditionalDeserialization() {
        System.out.println("1. Traditional Deserialization (No Filtering):");
        
        try {
            // Create a safe object
            SafeData safeData = new SafeData("Hello", 42);
            
            // Serialize
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(safeData);
            oos.close();
            
            // Deserialize without any filtering
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            SafeData deserialized = (SafeData) ois.readObject();
            ois.close();
            
            System.out.println("  Deserialized: " + deserialized);
            System.out.println("  Issue: No validation of incoming objects");
            
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateGlobalFilter() {
        System.out.println("2. Global Deserialization Filter (Java 9+):");
        
        // Set global filter
        ObjectInputFilter globalFilter = ObjectInputFilter.Config.createFilter(
            "java.lang.String;java.lang.Number;FiltersBefore$SafeData;!*"
        );
        ObjectInputFilter.Config.setSerialFilter(globalFilter);
        
        try {
            // Test with allowed class
            SafeData safeData = new SafeData("Filtered", 123);
            byte[] serialized = serialize(safeData);
            SafeData deserialized = (SafeData) deserialize(serialized);
            System.out.println("  Allowed class: " + deserialized);
            
            // Test with potentially dangerous class would be rejected
            System.out.println("  Global filter active: Only SafeData, String, Number allowed");
            
        } catch (Exception e) {
            System.out.println("  Filter rejection: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateSecurityIssues() {
        System.out.println("3. Security Issues with Traditional Approach:");
        System.out.println("  - Gadget chains: Malicious object graphs");
        System.out.println("  - Resource exhaustion: Large arrays, deep nesting");
        System.out.println("  - Code execution: Through finalize() or readObject()");
        System.out.println("  - No context awareness: Same filter for all use cases");
        
        // Simulate dangerous deserialization scenario
        System.out.println("  Example dangerous classes:");
        System.out.println("    - java.util.HashMap (hash collision DoS)");
        System.out.println("    - java.rmi.server.UnicastRemoteObject (RCE)");
        System.out.println("    - sun.reflect.annotation.AnnotationInvocationHandler");
        System.out.println();
    }
    
    private static void demonstrateLimitations() {
        System.out.println("4. Limitations of Pre-Java 17 Filtering:");
        System.out.println("  - Global filter affects entire JVM");
        System.out.println("  - No per-stream or per-context filtering");
        System.out.println("  - Difficult to have different policies for different use cases");
        System.out.println("  - All-or-nothing approach");
        System.out.println("  - Cannot adapt filter based on context");
        System.out.println("  - Limited flexibility for complex applications");
        System.out.println();
    }
    
    // Helper methods
    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close();
        return baos.toByteArray();
    }
    
    private static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object result = ois.readObject();
        ois.close();
        return result;
    }
    
    // Safe data class for demonstration
    static class SafeData implements Serializable {
        private static final long serialVersionUID = 1L;
        private String message;
        private int value;
        
        public SafeData(String message, int value) {
            this.message = message;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return "SafeData{message='" + message + "', value=" + value + "}";
        }
    }
}