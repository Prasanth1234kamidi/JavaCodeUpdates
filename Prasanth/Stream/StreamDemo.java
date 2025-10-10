package Stream;
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Prashanth", "Ravi", "Sita", "Prasad");

        names.stream()
             .filter(name -> name.toUpperCase().startsWith("P"))  // Intermediate
             .map(String::toUpperCase)              // Intermediate
             .forEach(System.out::println);         // Terminal
    }
}
