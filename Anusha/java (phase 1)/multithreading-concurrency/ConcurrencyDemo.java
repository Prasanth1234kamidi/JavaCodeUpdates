public class ConcurrencyDemo {
    public static void main(String[] args) {
        System.out.println("=== Concurrency Demo ===");
        
        System.out.println("Running parallel processing:");
        ConcurrencyExamples.parallelProcessing();
        
        System.out.println("\nRunning producer-consumer example:");
        ConcurrencyExamples.producerConsumerExample();
        
        System.out.println("\nRunning concurrent collections example:");
        ConcurrencyExamples.concurrentCollections();
        
        try {
            Thread.sleep(3000); // Wait for async operations
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Run: javac *.java && java ConcurrencyDemo