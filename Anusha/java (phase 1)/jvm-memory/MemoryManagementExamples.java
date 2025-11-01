import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.util.List;
import java.util.ArrayList;

class MemoryManagementExamples {
    
    // Memory monitoring
    public static void memoryInfo() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        
        System.out.println("Heap Memory Usage:");
        System.out.println("  Used: " + memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024) + " MB");
        System.out.println("  Max: " + memoryBean.getHeapMemoryUsage().getMax() / (1024 * 1024) + " MB");
        
        System.out.println("Non-Heap Memory Usage:");
        System.out.println("  Used: " + memoryBean.getNonHeapMemoryUsage().getUsed() / (1024 * 1024) + " MB");
        System.out.println("  Max: " + memoryBean.getNonHeapMemoryUsage().getMax() / (1024 * 1024) + " MB");
    }
    
    // Garbage collection information
    public static void gcInfo() {
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("GC Name: " + gcBean.getName());
            System.out.println("  Collection Count: " + gcBean.getCollectionCount());
            System.out.println("  Collection Time: " + gcBean.getCollectionTime() + " ms");
        }
    }
    
    // Memory-efficient object creation
    public static void efficientObjectCreation() {
        // Using records for memory efficiency
        record Point(int x, int y) {}
        
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            points.add(new Point(i, i * 2));
        }
        
        System.out.println("Created " + points.size() + " points efficiently");
    }
    
    // String interning for memory optimization
    public static void stringInterning() {
        String str1 = new String("Hello").intern();
        String str2 = "Hello";
        
        System.out.println("Strings are same reference: " + (str1 == str2));
        
        // Demonstrating memory savings with interning
        List<String> internedStrings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            internedStrings.add(("String-" + (i % 10)).intern());
        }
        
        System.out.println("Interned strings count: " + internedStrings.size());
    }
    
    // Weak references for cache-like behavior
    public static void weakReferences() {
        java.lang.ref.WeakReference<List<String>> weakRef = 
            new java.lang.ref.WeakReference<>(new ArrayList<>());
        
        System.out.println("Weak reference before GC: " + (weakRef.get() != null));
        
        // Suggest garbage collection
        System.gc();
        
        // Check if object was collected
        System.out.println("Weak reference after GC: " + (weakRef.get() != null));
    }
    
    public static void main(String[] args) {
        System.out.println("=== Memory Management Examples ===");
        memoryInfo();
        System.out.println();
        
        gcInfo();
        System.out.println();
        
        efficientObjectCreation();
        stringInterning();
        weakReferences();
    }
}