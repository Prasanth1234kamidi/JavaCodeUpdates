public class VirtualThreadDemo {
    public static void main(String[] args) {
        System.out.println("=== Virtual Threads Comparison Demo ===");
        
        System.out.println("\n--- Before Virtual Threads ---");
        BeforeVirtualThreads.main(args);
        
        System.out.println("\n--- After Virtual Threads (Simulated) ---");
        AfterVirtualThreads.main(args);
        
        try {
            Thread.sleep(1000); // Wait for threads to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}