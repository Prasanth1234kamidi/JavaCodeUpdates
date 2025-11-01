import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.security.SecureRandom;

/**
 * Enhanced PRNG Before Java 17
 * Shows traditional random number generation approaches
 */
public class PRNGBefore {
    public static void main(String[] args) {
        System.out.println("=== Enhanced PRNG Before Java 17 ===\n");
        
        // 1. Basic Random (Linear Congruential Generator)
        demonstrateBasicRandom();
        
        // 2. ThreadLocalRandom (better for multithreading)
        demonstrateThreadLocalRandom();
        
        // 3. SecureRandom (cryptographically secure)
        demonstrateSecureRandom();
        
        // 4. Custom seeded Random
        demonstrateSeededRandom();
        
        // 5. Performance comparison
        performanceComparison();
    }
    
    private static void demonstrateBasicRandom() {
        System.out.println("1. Basic Random (java.util.Random):");
        Random random = new Random();
        
        System.out.println("  Integers: " + random.nextInt(100) + ", " + random.nextInt(100));
        System.out.println("  Doubles: " + String.format("%.3f", random.nextDouble()) + 
                          ", " + String.format("%.3f", random.nextDouble()));
        System.out.println("  Gaussians: " + String.format("%.3f", random.nextGaussian()) + 
                          ", " + String.format("%.3f", random.nextGaussian()));
        System.out.println();
    }
    
    private static void demonstrateThreadLocalRandom() {
        System.out.println("2. ThreadLocalRandom (better for concurrent use):");
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        
        System.out.println("  Range integers: " + tlr.nextInt(10, 50) + ", " + tlr.nextInt(10, 50));
        System.out.println("  Range doubles: " + String.format("%.3f", tlr.nextDouble(1.0, 10.0)) + 
                          ", " + String.format("%.3f", tlr.nextDouble(1.0, 10.0)));
        System.out.println("  Range longs: " + tlr.nextLong(1000L, 9999L) + ", " + tlr.nextLong(1000L, 9999L));
        System.out.println();
    }
    
    private static void demonstrateSecureRandom() {
        System.out.println("3. SecureRandom (cryptographically secure):");
        SecureRandom secureRandom = new SecureRandom();
        
        System.out.println("  Secure integers: " + secureRandom.nextInt(1000) + ", " + secureRandom.nextInt(1000));
        
        byte[] randomBytes = new byte[8];
        secureRandom.nextBytes(randomBytes);
        System.out.println("  Random bytes: " + Arrays.toString(randomBytes));
        System.out.println();
    }
    
    private static void demonstrateSeededRandom() {
        System.out.println("4. Seeded Random (reproducible sequences):");
        Random seeded1 = new Random(12345L);
        Random seeded2 = new Random(12345L);
        
        System.out.println("  Same seed results:");
        System.out.println("    Generator 1: " + seeded1.nextInt(100) + ", " + seeded1.nextInt(100));
        System.out.println("    Generator 2: " + seeded2.nextInt(100) + ", " + seeded2.nextInt(100));
        System.out.println();
    }
    
    private static void performanceComparison() {
        System.out.println("5. Performance Comparison (1M operations):");
        int iterations = 1_000_000;
        
        // Basic Random
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < iterations; i++) {
            random.nextInt();
        }
        long basicTime = System.nanoTime() - start;
        
        // ThreadLocalRandom
        start = System.nanoTime();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (int i = 0; i < iterations; i++) {
            tlr.nextInt();
        }
        long tlrTime = System.nanoTime() - start;
        
        System.out.println("  Basic Random: " + (basicTime / 1_000_000) + " ms");
        System.out.println("  ThreadLocalRandom: " + (tlrTime / 1_000_000) + " ms");
        System.out.println("  ThreadLocalRandom is " + String.format("%.1fx", (double)basicTime / tlrTime) + " faster");
    }
}