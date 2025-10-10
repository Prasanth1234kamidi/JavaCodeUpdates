package FunctionalInterface;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printMessage = msg -> System.out.println("Message: " + msg);

        printMessage.accept("Hello Prashanth!");
        printMessage.accept("Java 8 is powerful!");
    }
}

