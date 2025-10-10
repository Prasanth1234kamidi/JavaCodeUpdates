package CompletableFuture;
import java.util.concurrent.CompletableFuture;

public class CombineDemo {
    public static void main(String[] args) {
        // Create two async tasks
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        // Combine results and print the sum
        future1.thenCombine(future2, (a, b) -> a + b)
               .thenAccept(sum -> System.out.println("Sum: " + sum));

        // Keep main thread alive until async tasks finish
        try {
            Thread.sleep(1000); // small delay to allow async completion
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
