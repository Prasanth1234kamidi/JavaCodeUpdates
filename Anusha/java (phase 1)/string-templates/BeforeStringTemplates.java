// Before String Templates - Traditional string formatting
class StringFormattingBefore {
    
    public static String createUserMessage(String name, int age, double balance) {
        // String concatenation (verbose and error-prone)
        return "Hello " + name + ", you are " + age + " years old and your balance is $" + balance;
    }
    
    public static String createReport(String product, int quantity, double price) {
        // String.format (better but still verbose)
        return String.format("Product: %s, Quantity: %d, Total: $%.2f", product, quantity, quantity * price);
    }
    
    public static String createHtml(String title, String content) {
        // StringBuilder for complex strings
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head><title>").append(title).append("</title></head>");
        sb.append("<body>");
        sb.append("<h1>").append(title).append("</h1>");
        sb.append("<p>").append(content).append("</p>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
    
    public static String createJson(String name, int id, boolean active) {
        // Manual JSON construction (error-prone)
        return "{" +
               "\"name\": \"" + name + "\", " +
               "\"id\": " + id + ", " +
               "\"active\": " + active +
               "}";
    }
}

public class BeforeStringTemplates {
    public static void main(String[] args) {
        System.out.println("=== Before String Templates ===");
        
        String name = "Alice";
        int age = 30;
        double balance = 1250.75;
        
        System.out.println("String concatenation:");
        System.out.println(StringFormattingBefore.createUserMessage(name, age, balance));
        
        System.out.println("\nString.format:");
        System.out.println(StringFormattingBefore.createReport("Laptop", 2, 999.99));
        
        System.out.println("\nStringBuilder:");
        System.out.println(StringFormattingBefore.createHtml("Welcome", "This is the content"));
        
        System.out.println("\nManual JSON:");
        System.out.println(StringFormattingBefore.createJson("Bob", 123, true));
    }
}