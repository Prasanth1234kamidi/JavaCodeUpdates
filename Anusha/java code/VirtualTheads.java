import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreads{

    // Number of simulated blocking tasks
    static final int TASKS = 1_000;
    // Each task sleeps to simulate blocking I/O
    static final int SLEEP_MS = 1000;

    public static void main(String[] args) throws Exception {
        System.out.println("Running with fixed thread pool (BEFORE)...");
        runWithFixedPool();

        System.out.println("\nRunning with virtual threads (AFTER)...");
        runWithVirtualThreads();
    }

    // BEFORE: classic fixed-size thread pool
    static void runWithFixedPool() throws Exception {
        int poolSize = 50; // typical sized pool you might have used
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        try {
            Instant start = Instant.now();
            CountDownLatch latch = new CountDownLatch(TASKS);
            for (int i = 0; i < TASKS; i++) {
                final int id = i;
                pool.submit(() -> {
                    simulateBlockingIO(id);
                    latch.countDown();
                });
            }
            latch.await(); // wait for all tasks to finish
            Instant end = Instant.now();
            System.out.println("Fixed pool size: " + poolSize + " tasks: " + TASKS +
                               " elapsed: " + Duration.between(start, end).toMillis() + " ms");
        } finally {
            pool.shutdownNow();
        }
    }

    // AFTER: virtual threads (one virtual thread per task)
    static void runWithVirtualThreads() throws Exception {
        // Use try-with-resources to shut down the virtual-thread executor cleanly
        try (ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            Instant start = Instant.now();
            CountDownLatch latch = new CountDownLatch(TASKS);
            for (int i = 0; i < TASKS; i++) {
                final int id = i;
                virtualExecutor.submit(() -> {
                    simulateBlockingIO(id);
                    latch.countDown();
                });
            }
            latch.await();
            Instant end = Instant.now();
            System.out.println("Virtual threads tasks: " + TASKS +
                               " elapsed: " + Duration.between(start, end).toMillis() + " ms");
        } // executor closed here
    }

    // Simulate blocking operation (e.g., blocking IO)
    static void simulateBlockingIO(int id) {
        try {
            // Here we block the thread to simulate IO (sleep)
            Thread.sleep(SLEEP_MS);
            // Optional: minimal print for first few to show activity
            if (id < 3) System.out.println("task " + id + " done on " + Thread.currentThread());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
