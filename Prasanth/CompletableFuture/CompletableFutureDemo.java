package CompletableFuture;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello from async task!";
        });

        future.thenAccept(result -> System.out.println(result));
    }
}
