public class AfterPattern {
    static String format(Object obj) {
        return switch (obj) {
            case Integer i -> {
                if (i > 10) yield "Large int " + i;
                else yield "Small int " + i;
            }
            case String s -> "String: " + s.toUpperCase();
            case null -> "Null value";
            default -> "Unknown type: " + obj.toString();
        };
    }

    public static void main(String[] args) {
        System.out.println(format(5));        // Small int 5
        System.out.println(format(50));       // Large int 50
        System.out.println(format("hello"));  // String: HELLO
        System.out.println(format(null));     // Null value
    }
}
