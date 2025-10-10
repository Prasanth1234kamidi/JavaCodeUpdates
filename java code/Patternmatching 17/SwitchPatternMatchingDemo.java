public class SwitchPatternMatchingDemo {
    public static void main(String[] args) {
        Object[] objects = { "Hello", 42, 3.14, true };

        for (Object obj : objects) {
            // Switch expression with pattern matching
            String result = switch (obj) {
                case String s -> "String in uppercase: " + s.toUpperCase();
                case Integer i -> "Integer doubled: " + (i * 2);
                case Double d -> "Double squared: " + (d * d);
                default -> "Other type: " + obj;
            };

            System.out.println(result);
        }
    }
}
