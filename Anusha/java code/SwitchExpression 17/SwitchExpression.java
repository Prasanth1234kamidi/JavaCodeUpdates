public class SwitchExpression{
        public static void main(String[] args)
    {
int day = 2;
String message = switch (day) {
    case 1, 2, 3, 4, 5 -> {
        String temp = "It's a weekday";
        yield temp.toUpperCase();  // yield returns the value from the block
    }
    case 6, 7 -> "It's weekend";
    default -> "Invalid day";
};

System.out.println(message); // IT'S A WEEKDAY
    }
    }
