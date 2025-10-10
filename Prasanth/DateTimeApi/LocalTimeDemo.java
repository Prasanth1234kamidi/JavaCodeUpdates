package DateTimeApi;
import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime meeting = LocalTime.of(15, 30);
        System.out.println("Meeting Time: " + meeting);
    }
}
