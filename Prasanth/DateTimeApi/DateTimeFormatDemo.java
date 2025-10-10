package DateTimeApi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatted = now.format(formatter);

        System.out.println("Formatted DateTime: " + formatted);
    }
}
