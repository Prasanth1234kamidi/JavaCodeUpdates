import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;

class ConcurrencyExamples {
    
    // Thread-safe counter using AtomicInteger
    private static final AtomicInteger counter = new AtomicInteger(0);
    
    // CompletableFuture for async operations
    public static CompletableFuture<String> asyncOperation(String input) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate work
                return "Processed: " + input;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Interrupted: " + input;
            }
        });
    }
    
    // Parallel processing with streams
    public static void parallelProcessing() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Parallel stream processing
        int sum = numbers.parallelStream()
            .mapToInt(n -> n * n)
            .sum();
        
        System.out.println("Sum of squares: " + sum);
    }
    
    // Producer-Consumer pattern with BlockingQueue
    public static void producerConsumerExample() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        
        // Producer
        Thread producer = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    String item = "Item-" + i;
                    queue.put(item);
                    System.out.println("Produced: " + item);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        // Consumer
        Thread consumer = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    String item = queue.take();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
    
    // Concurrent collection usage
    public static void concurrentCollections() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        
        // Multiple threads updating the map safely
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            Thread thread = Thread.ofVirtual().start(() -> {
                for (int j = 0; j < 10; j++) {
                    String key = "key-" + threadId + "-" + j;
                    map.put(key, counter.incrementAndGet());
                }
            });
            threads.add(thread);
        }
        
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        System.out.println("Map size: " + map.size());
        System.out.println("Counter value: " + counter.get());
    }
}