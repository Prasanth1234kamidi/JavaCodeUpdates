package switchExpression;

public class SwitchExpression {
  public static void main(String[] args) {		
		int day = 6;
		String message = switch (day) {
		    case 1, 2, 3, 4, 5 -> {
		        System.out.println("Processing weekday");
		        int remaining = 5 - day;
		        yield "Weekday, " + remaining + " days until weekend";
		    }
		    case 6, 7 -> {
		        System.out.println("Processing weekend");
		        yield "Weekend! Enjoy!";
		    }
		    default -> "Invalid day";
		};
		System.out.println(message);
	  }
    }
