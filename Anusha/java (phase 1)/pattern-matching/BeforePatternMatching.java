// Before Java 17 - Traditional instanceof and casting
class PatternMatchingBefore {
    
    public static String processObject(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return "String of length: " + str.length();
        } else if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            return "Integer value: " + num;
        } else if (obj instanceof Double) {
            Double dbl = (Double) obj;
            return "Double value: " + dbl;
        } else {
            return "Unknown type";
        }
    }
    
    public static void processShape(Object shape) {
        System.out.println("Processing shape: " + shape.getClass().getSimpleName());
    }
}

public class BeforePatternMatching {
    public static void main(String[] args) {
        System.out.println("=== Before Pattern Matching ===");
        
        Object[] objects = {"Hello", 42, 3.14, null, new Object()};
        
        for (Object obj : objects) {
            System.out.println("Processing: " + obj);
            System.out.println("Result: " + PatternMatchingBefore.processObject(obj));
        }
    }
}