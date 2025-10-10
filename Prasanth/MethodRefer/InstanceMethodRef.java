package MethodRefer;
import java.util.function.Consumer;

public class InstanceMethodRef {
    public void printMessage(String msg) {
        System.out.println("Message: " + msg);
    }

    public static void main(String[] args) {
        InstanceMethodRef obj = new InstanceMethodRef();

        // Lambda
        Consumer<String> con1 = msg -> obj.printMessage(msg);

        // Method Reference
        Consumer<String> con2 = obj::printMessage;

        con1.accept("Hello with Lambda");
        con2.accept("Hello with Method Reference");
    }
}
