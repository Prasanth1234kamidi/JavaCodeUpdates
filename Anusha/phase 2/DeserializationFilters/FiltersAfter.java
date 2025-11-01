import java.io.*;

/**
 * Context-Specific Deserialization Filters After Java 17
 * Shows enhanced filtering capabilities with context awareness
 */
public class FiltersAfter {
    public static void main(String[] args) {
        System.out.println("=== Context-Specific Deserialization Filters After Java 17 ===\n");
        
        // 1. Context-specific filters
        demonstrateContextSpecificFilters();
        
        // 2. Per-stream filters
        demonstratePerStreamFilters();
        
        // 3. Dynamic filter factories
        demonstrateDynamicFilters();
        
        // 4. Enhanced security
        demonstrateEnhancedSecurity();
    }
    
    private static void demonstrateContextSpecificFilters() {
        System.out.println("1. Context-Specific Filters:");
        
        try {
            // Different contexts need different filtering policies
            
            // Context 1: User data - strict filtering
            ObjectInputFilter userDataFilter = ObjectInputFilter.Config.createFilter(
                "FiltersAfter$UserData;java.lang.String;java.lang.Integer;!*"
            );
            
            UserData userData = new UserData("Alice", 25);
            byte[] userSerialized = serialize(userData);
            
            // Deserialize with user data context
            UserData deserializedUser = (UserData) deserializeWithFilter(userSerialized, userDataFilter);
            System.out.println("  User context: " + deserializedUser);
            
            // Context 2: Configuration data - different policy
            ObjectInputFilter configFilter = ObjectInputFilter.Config.createFilter(
                "FiltersAfter$ConfigData;java.lang.String;java.util.Properties;!*"
            );
            
            ConfigData configData = new ConfigData("app.properties", "debug=true");
            byte[] configSerialized = serialize(configData);
            
            ConfigData deserializedConfig = (ConfigData) deserializeWithFilter(configSerialized, configFilter);
            System.out.println("  Config context: " + deserializedConfig);
            
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstratePerStreamFilters() {
        System.out.println("2. Per-Stream Filters:");
        
        try {
            // Create filter factory for different streams
            ObjectInputFilter.FilterInfo.class.getName(); // Ensure class is loaded
            
            // Stream 1: Trusted source - more permissive
            ObjectInputFilter trustedFilter = info -> {
                if (info.serialClass() != null) {
                    String className = info.serialClass().getName();
                    if (className.startsWith("FiltersAfter$") || 
                        className.startsWith("java.lang.") ||
                        className.startsWith("java.util.")) {
                        return ObjectInputFilter.Status.ALLOWED;
                    }
                }
                return ObjectInputFilter.Status.REJECTED;
            };
            
            // Stream 2: Untrusted source - very restrictive
            ObjectInputFilter untrustedFilter = info -> {
                if (info.serialClass() != null) {
                    String className = info.serialClass().getName();
                    if (className.equals("FiltersAfter$SafeData") || 
                        className.equals("java.lang.String")) {
                        return ObjectInputFilter.Status.ALLOWED;
                    }
                }
                return ObjectInputFilter.Status.REJECTED;
            };
            
            SafeData safeData = new SafeData("Safe content", 100);
            byte[] serialized = serialize(safeData);
            
            // Use trusted filter
            SafeData fromTrusted = (SafeData) deserializeWithFilter(serialized, trustedFilter);
            System.out.println("  Trusted stream: " + fromTrusted);
            
            // Use untrusted filter
            SafeData fromUntrusted = (SafeData) deserializeWithFilter(serialized, untrustedFilter);
            System.out.println("  Untrusted stream: " + fromUntrusted);
            
        } catch (Exception e) {
            System.out.println("  Filter applied: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateDynamicFilters() {
        System.out.println("3. Dynamic Filter Factories:");
        
        // Create a filter factory that adapts based on context
        ObjectInputFilter.FilterInfo.class.getName(); // Ensure loaded
        
        ObjectInputFilter dynamicFilter = info -> {
            if (info.serialClass() == null) {
                return ObjectInputFilter.Status.UNDECIDED;
            }
            
            String className = info.serialClass().getName();
            
            // Dynamic rules based on various factors
            if (info.depth() > 10) {
                System.out.println("    Rejected: Too deep nesting (" + info.depth() + ")");
                return ObjectInputFilter.Status.REJECTED;
            }
            
            if (info.arrayLength() > 1000) {
                System.out.println("    Rejected: Array too large (" + info.arrayLength() + ")");
                return ObjectInputFilter.Status.REJECTED;
            }
            
            if (className.startsWith("FiltersAfter$") || 
                className.startsWith("java.lang.String") ||
                className.startsWith("java.lang.Integer")) {
                System.out.println("    Allowed: " + className);
                return ObjectInputFilter.Status.ALLOWED;
            }
            
            System.out.println("    Rejected: " + className);
            return ObjectInputFilter.Status.REJECTED;
        };
        
        try {
            SafeData data = new SafeData("Dynamic filtering", 200);
            byte[] serialized = serialize(data);
            SafeData deserialized = (SafeData) deserializeWithFilter(serialized, dynamicFilter);
            System.out.println("  Result: " + deserialized);
        } catch (Exception e) {
            System.out.println("  Dynamic filter result: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateEnhancedSecurity() {
        System.out.println("4. Enhanced Security Features:");
        System.out.println("  ✓ Context-aware filtering policies");
        System.out.println("  ✓ Per-stream filter configuration");
        System.out.println("  ✓ Dynamic filter adaptation");
        System.out.println("  ✓ Detailed filtering information (depth, array size, etc.)");
        System.out.println("  ✓ Better integration with application security models");
        System.out.println("  ✓ Reduced attack surface through precise control");
        System.out.println("  ✓ Improved auditability and logging");
        System.out.println();
        
        System.out.println("Benefits over pre-Java 17:");
        System.out.println("  - Multiple concurrent filter policies");
        System.out.println("  - Context-sensitive security decisions");
        System.out.println("  - Fine-grained control per use case");
        System.out.println("  - Better defense against deserialization attacks");
    }
    
    // Helper methods
    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close();
        return baos.toByteArray();
    }
    
    private static Object deserializeWithFilter(byte[] data, ObjectInputFilter filter) 
            throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        ois.setObjectInputFilter(filter);
        Object result = ois.readObject();
        ois.close();
        return result;
    }
    
    // Data classes for demonstration
    static class UserData implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;
        
        public UserData(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "UserData{name='" + name + "', age=" + age + "}";
        }
    }
    
    static class ConfigData implements Serializable {
        private static final long serialVersionUID = 1L;
        private String filename;
        private String content;
        
        public ConfigData(String filename, String content) {
            this.filename = filename;
            this.content = content;
        }
        
        @Override
        public String toString() {
            return "ConfigData{filename='" + filename + "', content='" + content + "'}";
        }
    }
    
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