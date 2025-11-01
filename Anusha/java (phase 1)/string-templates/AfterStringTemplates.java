// String Templates concept (Available in Java 21+)
// This simulates the syntax and benefits for Java 17

class StringTemplatesAfter {
    
    // Simulating String Template syntax with helper methods
    public static String createUserMessage(String name, int age, double balance) {
        // This would be: STR."Hello \{name}, you are \{age} years old and your balance is $\{balance}"
        return interpolate("Hello {}, you are {} years old and your balance is ${}", name, age, balance);
    }
    
    public static String createReport(String product, int quantity, double price) {
        // This would be: STR."Product: \{product}, Quantity: \{quantity}, Total: $\{quantity * price}"
        return interpolate("Product: {}, Quantity: {}, Total: ${}", product, quantity, String.format("%.2f", quantity * price));
    }
    
    public static String createHtml(String title, String content) {
        // This would be a multi-line string template:
        /*
        STR."""
        <html>
        <head><title>\{title}</title></head>
        <body>
        <h1>\{title}</h1>
        <p>\{content}</p>
        </body>
        </html>
        """
        */
        return interpolate("""
                <html>
                <head><title>{}</title></head>
                <body>
                <h1>{}</h1>
                <p>{}</p>
                </body>
                </html>""", title, title, content);
    }
    
    public static String createJson(String name, int id, boolean active) {
        // This would be: STR.'{"name": "\{name}", "id": \{id}, "active": \{active}}'
        return interpolate("{\"name\": \"{}\", \"id\": {}, \"active\": {}}", name, id, active);
    }
    
    // Helper method to simulate string interpolation
    private static String interpolate(String template, Object... args) {
        String result = template;
        for (Object arg : args) {
            result = result.replaceFirst("\\{\\}", String.valueOf(arg));
        }
        return result;
    }
    
    // Demonstrating the concept of processors
    public static String safeHtml(String template, Object... args) {
        String result = interpolate(template, args);
        // In real String Templates, this would be a custom processor
        return result.replace("<", "&lt;").replace(">", "&gt;");
    }
}

public class AfterStringTemplates {
    public static void main(String[] args) {
        System.out.println("=== String Templates Concept (Java 21+) ===");
        System.out.println("Note: Actual syntax requires Java 21+ with --enable-preview");
        
        String name = "Alice";
        int age = 30;
        double balance = 1250.75;
        
        System.out.println("Simulated String Template:");
        System.out.println(StringTemplatesAfter.createUserMessage(name, age, balance));
        
        System.out.println("\nWith expressions:");
        System.out.println(StringTemplatesAfter.createReport("Laptop", 2, 999.99));
        
        System.out.println("\nMulti-line template:");
        System.out.println(StringTemplatesAfter.createHtml("Welcome", "This is the content"));
        
        System.out.println("\nJSON template:");
        System.out.println(StringTemplatesAfter.createJson("Bob", 123, true));
        
        System.out.println("\nSafe HTML processing:");
        System.out.println(StringTemplatesAfter.safeHtml("Hello {}, <script>alert('xss')</script>", "User"));
        
        System.out.println("\n=== Actual Java 21+ Syntax ===");
        System.out.println("STR.\"Hello \\{name}, you are \\{age} years old\"");
        System.out.println("STR.\"Total: $\\{quantity * price}\"");
        System.out.println("Custom processors: HTML.\"<p>\\{content}</p>\"");
    }
}