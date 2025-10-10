package FunctionalInterface;

@FunctionalInterface
interface MyFunctionalInterface {
    void sayMessage(String message); // only one abstract method
}
//Without Lambda (Before Java 8):
public class FunctionalInter {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed without Lambda");
            }
        };
        new Thread(r).start();
    }
}
