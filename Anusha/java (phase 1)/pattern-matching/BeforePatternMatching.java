// Before Java 17 - Traditional switch with instanceof
class PatternMatchingBefore {
    
    public static String processObject(Object obj) {
        // Traditional approach: switch on type name + instanceof
        String typeName = obj == null ? "null" : obj.getClass().getSimpleName();
        
        switch (typeName) {
            case "String":
                String str = (String) obj;
                return "String of length: " + str.length();
            case "Integer":
                Integer num = (Integer) obj;
                return "Integer value: " + num;
            case "Double":
                Double dbl = (Double) obj;
                return "Double value: " + dbl;
            case "null":
                return "Null value";
            default:
                return "Unknown type";
        }
    }
    
    public static String categorizeNumber(Object obj) {
        // Traditional switch with multiple checks
        if (!(obj instanceof Integer)) {
            return "Not an integer";
        }
        
        Integer num = (Integer) obj;
        switch (Integer.signum(num)) {
            case 1:
                return "Positive integer";
            case -1:
                return "Negative integer";
            case 0:
            default:
                return "Zero";
        }
    }
    
    public static String processDay(String day) {
        // Traditional switch statement
        switch (day.toUpperCase()) {
            case "MONDAY":
            case "TUESDAY":
            case "WEDNESDAY":
            case "THURSDAY":
            case "FRIDAY":
                return "Weekday";
            case "SATURDAY":
            case "SUNDAY":
                return "Weekend";
            default:
                return "Invalid day";
        }
    }
}

public class BeforePatternMatching {
    public static void main(String[] args) {
        System.out.println("=== Before Pattern Matching (Traditional Switch) ===");
        
        Object[] objects = {"Hello", 42, -5, 3.14, null, new Object()};
        String[] days = {"MONDAY", "SATURDAY", "INVALID"};
        
        System.out.println("\n--- Traditional Switch Approaches ---");
        System.out.println("1. Switch on type name + casting:");
        for (Object obj : objects) {
            System.out.println(obj + " -> " + PatternMatchingBefore.processObject(obj));
        }
        
        System.out.println("\n2. Traditional switch statements:");
        for (String day : days) {
            System.out.println(day + " -> " + PatternMatchingBefore.processDay(day));
        }
        
        System.out.println("\n3. Switch with helper methods:");
        for (Object obj : objects) {
            System.out.println(obj + " -> " + PatternMatchingBefore.categorizeNumber(obj));
        }
        
        System.out.println("\n--- Problems with Traditional Approach ---");
        System.out.println("• Switch on type names is fragile");
        System.out.println("• Explicit casting required");
        System.out.println("• Potential ClassCastException");
        System.out.println("• Verbose and repetitive code");
        System.out.println("• No compile-time type safety");
    }
}