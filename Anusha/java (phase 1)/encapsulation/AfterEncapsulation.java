// Java 17 - Using public APIs instead of internal ones
import java.nio.ByteBuffer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class EncapsulationAfter {
    
    // Safe memory operations using public APIs
    public static void safeMemoryExample() {
        // Using ByteBuffer for safe memory operations
        ByteBuffer buffer = ByteBuffer.allocateDirect(8);
        buffer.putLong(12345L);
        buffer.flip();
        System.out.println("Value: " + buffer.getLong());
        
        // Alternative safe memory approach
        System.out.println("Using ByteBuffer for safe memory operations");
    }
    
    // Using standard XML parser APIs
    public static void standardParserExample() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Use standard, supported APIs
            System.out.println("Using standard XML parser");
        } catch (Exception e) {
            System.err.println("Error with standard parser: " + e.getMessage());
        }
    }
    
    // Alternative approaches for reflection
    public static void safeReflectionExample() {
        try {
            // Use public APIs and proper module access
            Class<?> stringClass = String.class;
            var methods = stringClass.getDeclaredMethods();
            System.out.println("String has " + methods.length + " methods");
        } catch (Exception e) {
            System.err.println("Reflection error: " + e.getMessage());
        }
    }
}