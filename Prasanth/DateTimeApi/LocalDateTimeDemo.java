package DateTimeApi;
import java.time.LocalDateTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current DateTime: " + current);

        LocalDateTime event = LocalDateTime.of(2025, 12, 25, 10, 0);
        System.out.println("Event DateTime: " + event);
    }
}
