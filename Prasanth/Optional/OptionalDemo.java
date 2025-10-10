package Optional;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("Prashanth");

        // Check if value present
        if(name.isPresent()) {
            System.out.println(name.get().toUpperCase());
        }

        // Or simpler: ifPresent
        name.ifPresent(n -> System.out.println("Hello " + n));

        // Default value if empty
        String finalName = name.orElse("Default Name");
        System.out.println(finalName);
    }
}
