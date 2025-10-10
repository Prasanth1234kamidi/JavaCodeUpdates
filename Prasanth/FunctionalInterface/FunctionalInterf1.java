package FunctionalInterface;

@FunctionalInterface
interface MyFunctionalInterface1 {
    void sayMessage(String message); // only one abstract method
}
public class FunctionalInterf1 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Task executed with Lambda");
        new Thread(r).start();
    }
}
