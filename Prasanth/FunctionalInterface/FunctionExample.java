package FunctionalInterface;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> strLength = str -> str.length();

        System.out.println(strLength.apply("Prashanth")); // 9
        System.out.println(strLength.apply("Java")); // 4
    }
}
