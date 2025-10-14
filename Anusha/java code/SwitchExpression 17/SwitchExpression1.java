public class SwitchExpression1 {
    public static void main(String[] args) {
        int day = 6;

        // Switch is now an expression
        String result = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };

        System.out.println("Switch Expression Result: " + result);
    }
}
