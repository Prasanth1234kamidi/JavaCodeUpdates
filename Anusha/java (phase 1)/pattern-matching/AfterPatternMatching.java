// Java 17 - Pattern matching with instanceof (Java 21+ switch concept)
class PatternMatchingAfter {
    
    // Java 17: Pattern matching with instanceof
    public static String processObject(Object obj) {
        if (obj instanceof String str) {
            return "String of length: " + str.length();
        } else if (obj instanceof Integer num) {
            return "Integer value: " + num;
        } else if (obj instanceof Double dbl) {
            return "Double value: " + dbl;
        } else if (obj == null) {
            return "Null value";
        } else {
            return "Unknown type";
        }
    }
    
    // Java 21+ Pattern matching for switch (CONCEPT ONLY)
    public static String processObjectSwitchConcept(Object obj) {
        // FUTURE Java 21+ syntax (NOT AVAILABLE IN JAVA 17):
        /*
        return switch (obj) {
            case String str -> "String of length: " + str.length();
            case Integer num -> "Integer value: " + num;
            case Double dbl -> "Double value: " + dbl;
            case null -> "Null value";
            default -> "Unknown type";
        };
        */
        
        // Java 17 equivalent using instanceof:
        return processObject(obj);
    }
    
    // Java 17: Enhanced switch expressions (without pattern matching)
    public static String processDay(String day) {
        return switch (day.toUpperCase()) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Invalid day";
        };
    }
    
    public static void processShape(Object shape) {
        System.out.println("Processing shape with pattern matching: " + shape.getClass().getSimpleName());
    }
    
    // Guard conditions concept (Java 21+ FUTURE FEATURE)
    public static String categorizeNumberConcept(Object obj) {
        // FUTURE Java 21+ syntax with guard conditions:
        /*
        return switch (obj) {
            case Integer i when i > 0 -> "Positive integer";
            case Integer i when i < 0 -> "Negative integer";
            case Integer i -> "Zero";
            default -> "Not an integer";
        };
        */
        
        // Java 17 equivalent:
        if (obj instanceof Integer i) {
            if (i > 0) return "Positive integer";
            if (i < 0) return "Negative integer";
            return "Zero";
        }
        return "Not an integer";
    }
    
    // Java 17: Traditional categorization
    public static String categorizeNumber(Object obj) {
        if (obj instanceof Integer i) {
            return switch (Integer.signum(i)) {
                case 1 -> "Positive integer";
                case -1 -> "Negative integer";
                default -> "Zero";
            };
        }
        return "Not an integer";
    }
}

public class AfterPatternMatching {
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching: Java 17 vs Java 21+ ===");
        
        Object[] objects = {"Hello", 42, -5, 3.14, null, new Object()};
        String[] days = {"MONDAY", "SATURDAY", "INVALID"};
        
        System.out.println("\n--- Java 17 Available Features ---");
        System.out.println("1. instanceof with pattern variables:");
        for (Object obj : objects) {
            System.out.println(obj + " -> " + PatternMatchingAfter.processObject(obj));
        }
        
        System.out.println("\n2. Enhanced switch expressions:");
        for (String day : days) {
            System.out.println(day + " -> " + PatternMatchingAfter.processDay(day));
        }
        
        System.out.println("\n3. Switch with pattern-like logic:");
        for (Object obj : objects) {
            System.out.println(obj + " -> " + PatternMatchingAfter.categorizeNumber(obj));
        }
        
        System.out.println("\n--- Java 21+ Future Features (CONCEPTS) ---");
        System.out.println("• Pattern matching for switch: case String s -> ...");
        System.out.println("• Guard conditions: case Integer i when i > 0 -> ...");
        System.out.println("• Record patterns: case Point(var x, var y) -> ...");
        System.out.println("• Array patterns: case int[] {1, 2, var rest} -> ...");
        
        System.out.println("\nFuture syntax example:");
        System.out.println("switch (obj) {");
        System.out.println("    case String s when s.length() > 5 -> \"Long string\";");
        System.out.println("    case Integer i when i > 0 -> \"Positive: \" + i;");
        System.out.println("    case null -> \"Null value\";");
        System.out.println("    default -> \"Unknown\";");
        System.out.println("}");
    }
}