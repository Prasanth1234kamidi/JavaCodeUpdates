package CompletableFuture;
import java.util.concurrent.CompletableFuture;

public class ChainExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Fetching data...");
            return 20;
        }).thenApply(data -> {
            System.out.println("Step 2: Processing data...");
            return data * 2;
        }).thenAccept(result -> {
            System.out.println("Step 3: Final result: " + result);
        }).exceptionally(ex -> {
            System.out.println("Error: " + ex.getMessage());
            return null;
        });

        try { Thread.sleep(2000); } catch(Exception e) {}
    }
}
