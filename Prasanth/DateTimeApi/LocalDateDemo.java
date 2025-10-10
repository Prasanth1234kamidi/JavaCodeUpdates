package DateTimeApi;
import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today); // e.g., 2025-09-21

        LocalDate dob = LocalDate.of(2003, 1, 15);
        System.out.println("Date of Birth: " + dob);

        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("Next Week: " + nextWeek);
    }
}
