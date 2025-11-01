import java.util.*;
import java.util.random.*;
import java.util.stream.IntStream;

/**
 * Enhanced PRNG After Java 17
 * Shows new RandomGenerator API and enhanced algorithms
 */
public class PRNGAfter {
    public static void main(String[] args) {
        System.out.println("=== Enhanced PRNG After Java 17 ===\n");
        
        // 1. New RandomGenerator interface
        demonstrateRandomGenerator();
        
        // 2. Multiple algorithm support
        demonstrateAlgorithms();
        
        // 3. RandomGeneratorFactory
        demonstrateFactory();
        
        // 4. Splittable generators
        demonstrateSplittable();
        
        // 5. Jumpable generators
        demonstrateJumpable();
        
        // 6. Seeded generators (reproducible sequences)
        demonstrateSeededGenerators();
        
        // 7. Stream generation
        demonstrateStreams();
        
        // 8. Performance comparison of algorithms
        algorithmPerformance();
    }
    
    private static void demonstrateRandomGenerator() {
        System.out.println("1. RandomGenerator Interface:");
        RandomGenerator rng = RandomGenerator.getDefault();
        
        System.out.println("  Default algorithm: " + rng.getClass().getSimpleName());
        System.out.println("  Integers: " + rng.nextInt(100) + ", " + rng.nextInt(100));
        System.out.println("  Doubles: " + String.format("%.3f", rng.nextDouble()) + 
                          ", " + String.format("%.3f", rng.nextDouble()));
        System.out.println("  Exponential: " + String.format("%.3f", rng.nextExponential()));
        System.out.println();
    }
    
    private static void demonstrateAlgorithms() {
        System.out.println("2. Available Algorithms:");
        String[] algorithms = {"L32X64MixRandom", "L64X128MixRandom", "L64X256MixRandom", "Xoshiro256PlusPlus"};
        
        for (String algo : algorithms) {
            try {
                RandomGenerator rng = RandomGenerator.of(algo);
                System.out.println("  " + algo + ": " + rng.nextInt(1000));
            } catch (Exception e) {
                System.out.println("  " + algo + ": Not available");
            }
        }
        System.out.println();
    }
    
    private static void demonstrateFactory() {
        System.out.println("3. RandomGeneratorFactory:");
        
        // List all available generators
        System.out.println("  Available generators:");
        RandomGeneratorFactory.all()
            .map(RandomGeneratorFactory::name)
            .sorted()
            .limit(5)
            .forEach(name -> System.out.println("    - " + name));
        
        // Create specific generator
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("L64X128MixRandom");
        RandomGenerator rng = factory.create(42L);
        System.out.println("  L64X128MixRandom sample: " + rng.nextInt(1000));
        System.out.println();
    }
    
    private static void demonstrateSplittable() {
        System.out.println("4. SplittableGenerator (for parallel processing):");
        
        RandomGenerator splittable = RandomGenerator.of("L64X128MixRandom");
        
        if (splittable instanceof RandomGenerator.SplittableGenerator) {
            RandomGenerator.SplittableGenerator sg = (RandomGenerator.SplittableGenerator) splittable;
            RandomGenerator.SplittableGenerator split1 = sg.split();
            RandomGenerator.SplittableGenerator split2 = sg.split();
            
            System.out.println("  Original: " + sg.nextInt(100));
            System.out.println("  Split 1: " + split1.nextInt(100));
            System.out.println("  Split 2: " + split2.nextInt(100));
        } else {
            System.out.println("  Generator doesn't support splitting");
        }
        System.out.println();
    }
    
    private static void demonstrateJumpable() {
        System.out.println("5. JumpableGenerator (skip ahead in sequence):");
        
        RandomGenerator jumpable = RandomGenerator.of("Xoshiro256PlusPlus");
        
        if (jumpable instanceof RandomGenerator.JumpableGenerator) {
            RandomGenerator.JumpableGenerator jg = (RandomGenerator.JumpableGenerator) jumpable;
            System.out.println("  Before jump: " + jg.nextInt(100));
            jg.jump(); // Skip ahead in sequence
            System.out.println("  After jump: " + jg.nextInt(100));
            
            // Long jump (skip even further)
            if (jg instanceof RandomGenerator.LeapableGenerator) {
                ((RandomGenerator.LeapableGenerator) jg).leap();
                System.out.println("  After leap: " + jg.nextInt(100));
            }
        } else {
            System.out.println("  Generator doesn't support jumping");
        }
        System.out.println();
    }
    
    private static void demonstrateSeededGenerators() {
        System.out.println("6. Seeded RandomGenerators (reproducible sequences):");
        
        // Create seeded generators using factory
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("L64X128MixRandom");
        RandomGenerator seeded1 = factory.create(12345L);
        RandomGenerator seeded2 = factory.create(12345L);
        
        System.out.println("  Same seed results (L64X128MixRandom):");
        System.out.println("    Generator 1: " + seeded1.nextInt(100) + ", " + seeded1.nextInt(100));
        System.out.println("    Generator 2: " + seeded2.nextInt(100) + ", " + seeded2.nextInt(100));
        
        // Different algorithms with same seed
        RandomGenerator xoshiro = RandomGeneratorFactory.of("Xoshiro256PlusPlus").create(54321L);
        RandomGenerator l32x64 = RandomGeneratorFactory.of("L32X64MixRandom").create(54321L);
        
        System.out.println("  Different algorithms, same seed:");
        System.out.println("    Xoshiro256PlusPlus: " + xoshiro.nextInt(1000));
        System.out.println("    L32X64MixRandom: " + l32x64.nextInt(1000));
        System.out.println();
    }
    
    private static void demonstrateStreams() {
        System.out.println("7. Stream Generation:");
        RandomGenerator rng = RandomGenerator.getDefault();
        
        // Generate streams of random numbers
        System.out.println("  Random integers (0-9): " + 
            rng.ints(5, 0, 10)
               .mapToObj(String::valueOf)
               .reduce((a, b) -> a + ", " + b)
               .orElse(""));
        
        System.out.println("  Random doubles: " + 
            rng.doubles(3, 1.0, 10.0)
               .mapToObj(d -> String.format("%.2f", d))
               .reduce((a, b) -> a + ", " + b)
               .orElse(""));
        System.out.println();
    }
    
    private static void algorithmPerformance() {
        System.out.println("8. Algorithm Performance (1M operations):");
        String[] algorithms = {"Random", "L32X64MixRandom", "L64X128MixRandom", "Xoshiro256PlusPlus"};
        int iterations = 1_000_000;
        
        for (String algo : algorithms) {
            try {
                RandomGenerator rng = algo.equals("Random") ? 
                    new Random() : RandomGenerator.of(algo);
                
                long start = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    rng.nextInt();
                }
                long time = System.nanoTime() - start;
                
                System.out.println("  " + algo + ": " + (time / 1_000_000) + " ms");
            } catch (Exception e) {
                System.out.println("  " + algo + ": Not available");
            }
        }
    }
}