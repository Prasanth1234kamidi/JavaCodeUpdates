import jdk.incubator.vector.*;

/**
 * Vector API After Java 17
 * Shows new Vector API for SIMD operations
 * Note: Requires --add-modules jdk.incubator.vector
 */
public class VectorAfter {
    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;
    
    public static void main(String[] args) {
        System.out.println("=== Vector API After Java 17 ===\n");
        
        try {
            // 1. Basic vector operations
            demonstrateBasicVectorOps();
            
            // 2. Vector arithmetic
            demonstrateVectorArithmetic();
            
            // 3. Performance comparison
            performanceComparison();
            
            // 4. Advanced vector operations
            demonstrateAdvancedOps();
            
        } catch (Exception e) {
            System.out.println("Vector API not available or not enabled.");
            System.out.println("Run with: --add-modules jdk.incubator.vector");
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateBasicVectorOps() {
        System.out.println("1. Basic Vector Operations:");
        
        float[] a = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f};
        float[] b = {8.0f, 7.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.0f};
        float[] result = new float[a.length];
        
        System.out.println("  Vector species: " + SPECIES);
        System.out.println("  Vector length: " + SPECIES.length() + " elements");
        System.out.println("  Vector size: " + SPECIES.vectorBitSize() + " bits");
        
        // Load vectors
        FloatVector va = FloatVector.fromArray(SPECIES, a, 0);
        FloatVector vb = FloatVector.fromArray(SPECIES, b, 0);
        
        // Vector addition
        FloatVector vresult = va.add(vb);
        
        // Store result
        vresult.intoArray(result, 0);
        
        System.out.println("  Array A: " + java.util.Arrays.toString(a));
        System.out.println("  Array B: " + java.util.Arrays.toString(b));
        System.out.println("  A + B:   " + java.util.Arrays.toString(result));
        System.out.println("  Processing: " + SPECIES.length() + " elements simultaneously");
        System.out.println();
    }
    
    private static void demonstrateVectorArithmetic() {
        System.out.println("2. Vector Arithmetic Operations:");
        
        float[] data = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f};
        float[] result = new float[data.length];
        
        FloatVector v = FloatVector.fromArray(SPECIES, data, 0);
        
        // Complex arithmetic: (v * 2.0) + 1.0
        FloatVector vresult = v.mul(2.0f).add(1.0f);
        vresult.intoArray(result, 0);
        
        System.out.println("  Input:  " + java.util.Arrays.toString(data));
        System.out.println("  (v*2)+1: " + java.util.Arrays.toString(result));
        
        // Fused multiply-add
        FloatVector fma = v.fma(FloatVector.broadcast(SPECIES, 3.0f), FloatVector.broadcast(SPECIES, 2.0f));
        fma.intoArray(result, 0);
        System.out.println("  FMA(v,3,2): " + java.util.Arrays.toString(result));
        
        // Math functions
        FloatVector sqrt = v.lanewise(VectorOperators.SQRT);
        sqrt.intoArray(result, 0);
        System.out.println("  sqrt(v): " + java.util.Arrays.toString(result));
        System.out.println();
    }
    
    private static void performanceComparison() {
        System.out.println("3. Performance Comparison (1M elements):");
        
        int size = 1_000_000;
        float[] a = new float[size];
        float[] b = new float[size];
        float[] result = new float[size];
        
        // Initialize
        for (int i = 0; i < size; i++) {
            a[i] = i * 0.5f;
            b[i] = i * 1.5f;
        }
        
        // Scalar version
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            result[i] = a[i] * b[i] + a[i];
        }
        long scalarTime = System.nanoTime() - start;
        
        // Vector version
        start = System.nanoTime();
        int vectorLength = SPECIES.length();
        int i = 0;
        for (; i < size - vectorLength + 1; i += vectorLength) {
            FloatVector va = FloatVector.fromArray(SPECIES, a, i);
            FloatVector vb = FloatVector.fromArray(SPECIES, b, i);
            FloatVector vresult = va.fma(vb, va); // a * b + a
            vresult.intoArray(result, i);
        }
        
        // Handle remaining elements
        for (; i < size; i++) {
            result[i] = a[i] * b[i] + a[i];
        }
        long vectorTime = System.nanoTime() - start;
        
        System.out.println("  Scalar time: " + (scalarTime / 1_000_000) + " ms");
        System.out.println("  Vector time: " + (vectorTime / 1_000_000) + " ms");
        System.out.println("  Speedup: " + String.format("%.2fx", (double) scalarTime / vectorTime));
        System.out.println();
    }
    
    private static void demonstrateAdvancedOps() {
        System.out.println("4. Advanced Vector Operations:");
        
        float[] data = {1.0f, -2.0f, 3.0f, -4.0f, 5.0f, -6.0f, 7.0f, -8.0f};
        float[] result = new float[data.length];
        
        FloatVector v = FloatVector.fromArray(SPECIES, data, 0);
        
        // Absolute values
        FloatVector abs = v.abs();
        abs.intoArray(result, 0);
        System.out.println("  abs(v): " + java.util.Arrays.toString(result));
        
        // Conditional operations (mask-based)
        VectorMask<Float> mask = v.compare(VectorOperators.GT, 0.0f);
        FloatVector conditional = v.blend(FloatVector.zero(SPECIES), mask);
        conditional.intoArray(result, 0);
        System.out.println("  positive only: " + java.util.Arrays.toString(result));
        
        // Reduction operations
        float sum = v.reduceLanes(VectorOperators.ADD);
        float max = v.reduceLanes(VectorOperators.MAX);
        System.out.println("  sum: " + sum + ", max: " + max);
        
        // Rearrangement
        FloatVector reversed = v.rearrange(VectorShuffle.fromOp(SPECIES, i -> SPECIES.length() - 1 - i));
        reversed.intoArray(result, 0);
        System.out.println("  reversed: " + java.util.Arrays.toString(result));
        
        System.out.println("\n  Vector API Benefits:");
        System.out.println("  ✓ Direct SIMD instruction mapping");
        System.out.println("  ✓ Predictable vectorization");
        System.out.println("  ✓ Cross-platform portability");
        System.out.println("  ✓ Rich set of operations");
        System.out.println("  ✓ Type-safe vector programming");
        System.out.println();
    }
}