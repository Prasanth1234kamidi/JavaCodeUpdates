import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Shyam", "Charan");
        names.forEach(name -> System.out.println("Hello " + name));
    }
}
