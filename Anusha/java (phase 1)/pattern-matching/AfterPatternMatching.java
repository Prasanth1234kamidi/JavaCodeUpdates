// Java 17 - Pattern matching with instanceof
class PatternMatchingAfter {
    
    public static String processObject(Object obj) {
        if (obj instanceof String str) {
            return "String of length: " + str.length();
        } else if (obj instanceof Integer num) {
            return "Integer value: " + num;
        } else if (obj instanceof Double dbl) {
            return "Double value: " + dbl;
        } else {
            return "Unknown type";
        }
    }
    
    // Simplified switch for Java 17
    public static String processObjectSwitch(Object obj) {
        if (obj == null) return "Null value";
        if (obj instanceof String str) return "String of length: " + str.length();
        if (obj instanceof Integer num) return "Integer value: " + num;
        if (obj instanceof Double dbl) return "Double value: " + dbl;
        return "Unknown type";
    }
    
    public static void processShape(Object shape) {
        System.out.println("Processing shape with pattern matching: " + shape.getClass().getSimpleName());
    }
    
    // Guard conditions
    public static String categorizeNumber(Object obj) {
        if (obj instanceof Integer i) {
            if (i > 0) return "Positive integer";
            if (i < 0) return "Negative integer";
            return "Zero";
        }
        return "Not an integer";
    }
}

public class AfterPatternMatching {
    public static void main(String[] args) {
        System.out.println("=== After Pattern Matching (Java 17) ===");
        
        Object[] objects = {"Hello", 42, 3.14, null, new Object()};
        
        for (Object obj : objects) {
            System.out.println("Processing: " + obj);
            System.out.println("Result: " + PatternMatchingAfter.processObject(obj));
            System.out.println("Number Category: " + PatternMatchingAfter.categorizeNumber(obj));
            System.out.println("---");
        }
    }
}