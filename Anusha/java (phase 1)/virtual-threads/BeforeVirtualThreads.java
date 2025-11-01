// Before Virtual Threads - Platform threads with thread pools
import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

class VirtualThreadsBefore {
    
    public static void traditionalThreadPool() {
        System.out.println("=== Traditional Thread Pool ===");
        
        // Limited by platform thread count
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        List<Future<String>> futures = new ArrayList<>();
        
        // Creating 50 tasks - limited by thread pool size
        for (int i = 0; i < 50; i++) {
            final int taskId = i;
            Future<String> future = executor.submit(() -> {
                try {
                    Thread.sleep(100);
                    return "Task " + taskId + " completed by " + Thread.currentThread().getName();
                } catch (InterruptedException e) {
                    return "Task " + taskId + " interrupted";
                }
            });
            futures.add(future);
        }
        
        // Collect first 10 results for demo
        for (int i = 0; i < Math.min(10, futures.size()); i++) {
            try {
                System.out.println(futures.get(i).get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        executor.shutdown();
        System.out.println("Thread pool limited to 10 threads for " + futures.size() + " tasks");
    }
    
    public static void showLimitations() {
        System.out.println("\n=== Platform Thread Limitations ===");
        System.out.println("- Limited by OS thread count");
        System.out.println("- High memory overhead per thread");
        System.out.println("- Context switching overhead");
        System.out.println("- Blocking I/O ties up threads");
    }
}

public class BeforeVirtualThreads {
    public static void main(String[] args) {
        VirtualThreadsBefore.traditionalThreadPool();
        VirtualThreadsBefore.showLimitations();
    }
}