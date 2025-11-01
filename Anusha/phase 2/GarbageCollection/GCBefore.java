import java.lang.management.*;
import java.util.*;

/**
 * Garbage Collection Before Java 17
 * Shows traditional GC behavior and limitations
 */
public class GCBefore {
    public static void main(String[] args) {
        System.out.println("=== Garbage Collection Before Java 17 ===\n");
        
        // 1. Current GC information
        demonstrateCurrentGC();
        
        // 2. Traditional GC behavior
        demonstrateTraditionalGC();
        
        // 3. Memory allocation patterns
        demonstrateMemoryAllocation();
        
        // 4. GC limitations
        demonstrateLimitations();
    }
    
    private static void demonstrateCurrentGC() {
        System.out.println("1. Current GC Information:");
        
        // Get GC information
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        
        System.out.println("  Available GC algorithms:");
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("    - " + gcBean.getName());
            System.out.println("      Collections: " + gcBean.getCollectionCount());
            System.out.println("      Time: " + gcBean.getCollectionTime() + " ms");
        }
        
        // Memory information
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        
        System.out.println("  Heap Memory:");
        System.out.println("    Used: " + (heapUsage.getUsed() / 1024 / 1024) + " MB");
        System.out.println("    Max: " + (heapUsage.getMax() / 1024 / 1024) + " MB");
        System.out.println();
    }
    
    private static void demonstrateTraditionalGC() {
        System.out.println("2. Traditional GC Behavior:");
        
        System.out.println("  Common GC algorithms before Java 17:");
        System.out.println("    - Serial GC: Single-threaded, suitable for small applications");
        System.out.println("    - Parallel GC: Multi-threaded, default for server applications");
        System.out.println("    - G1GC: Low-latency collector for large heaps");
        System.out.println("    - CMS: Concurrent Mark Sweep (deprecated in Java 9)");
        
        // Simulate memory pressure
        System.out.println("\n  Simulating memory allocation...");
        List<byte[]> memoryHog = new ArrayList<>();
        
        long startTime = System.currentTimeMillis();
        long startCollections = getTotalCollections();
        
        try {
            // Allocate memory to trigger GC
            for (int i = 0; i < 1000; i++) {
                memoryHog.add(new byte[1024 * 1024]); // 1MB each
                if (i % 100 == 0) {
                    System.out.print(".");
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\n    OutOfMemoryError occurred (expected)");
        }
        
        long endTime = System.currentTimeMillis();
        long endCollections = getTotalCollections();
        
        System.out.println("\n  Allocation results:");
        System.out.println("    Time taken: " + (endTime - startTime) + " ms");
        System.out.println("    GC collections triggered: " + (endCollections - startCollections));
        
        // Clear memory
        memoryHog.clear();
        System.gc(); // Suggest GC
        System.out.println();
    }
    
    private static void demonstrateMemoryAllocation() {
        System.out.println("3. Memory Allocation Patterns:");
        
        // Short-lived objects
        System.out.println("  Testing short-lived objects...");
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String temp = "Temporary string " + i;
            temp.toUpperCase(); // Create more garbage
        }
        long shortLivedTime = System.nanoTime() - start;
        
        // Long-lived objects
        System.out.println("  Testing long-lived objects...");
        List<String> longLived = new ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            longLived.add("Long-lived string " + i);
        }
        long longLivedTime = System.nanoTime() - start;
        
        System.out.println("  Results:");
        System.out.println("    Short-lived allocation: " + (shortLivedTime / 1_000_000) + " ms");
        System.out.println("    Long-lived allocation: " + (longLivedTime / 1_000_000) + " ms");
        
        longLived.clear();
        System.out.println();
    }
    
    private static void demonstrateLimitations() {
        System.out.println("4. Traditional GC Limitations:");
        
        System.out.println("  Stop-the-World Issues:");
        System.out.println("    - Application pauses during GC");
        System.out.println("    - Pause times increase with heap size");
        System.out.println("    - Unpredictable pause durations");
        
        System.out.println("  Scalability Problems:");
        System.out.println("    - Poor performance with large heaps (>32GB)");
        System.out.println("    - GC overhead increases with heap size");
        System.out.println("    - Memory fragmentation issues");
        
        System.out.println("  Latency Concerns:");
        System.out.println("    - High tail latencies in applications");
        System.out.println("    - Difficult to achieve consistent response times");
        System.out.println("    - GC tuning complexity");
        
        // Demonstrate pause measurement
        System.out.println("\n  Measuring GC impact:");
        measureGCPauses();
    }
    
    private static void measureGCPauses() {
        List<Long> pauseTimes = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            
            // Allocate memory to trigger GC
            for (int j = 0; j < 10000; j++) {
                objects.add(new byte[1024]);
            }
            
            long end = System.nanoTime();
            pauseTimes.add((end - start) / 1_000_000); // Convert to ms
            
            // Clear some objects
            if (objects.size() > 50000) {
                objects.subList(0, 25000).clear();
            }
        }
        
        System.out.println("  Sample allocation times (ms): " + pauseTimes);
        
        double average = pauseTimes.stream().mapToLong(Long::longValue).average().orElse(0.0);
        long max = pauseTimes.stream().mapToLong(Long::longValue).max().orElse(0L);
        
        System.out.println("  Average time: " + String.format("%.2f", average) + " ms");
        System.out.println("  Max time: " + max + " ms");
        System.out.println("  Variability: High (traditional GC characteristic)");
    }
    
    private static long getTotalCollections() {
        return ManagementFactory.getGarbageCollectorMXBeans()
            .stream()
            .mapToLong(GarbageCollectorMXBean::getCollectionCount)
            .sum();
    }
}