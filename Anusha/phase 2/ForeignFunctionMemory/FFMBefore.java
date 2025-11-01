import java.nio.ByteBuffer;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * Foreign Function & Memory Before Java 17
 * Shows traditional JNI and unsafe memory access
 */
public class FFMBefore {
    private static Unsafe unsafe;
    
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            System.err.println("Cannot access Unsafe: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Foreign Function & Memory Before Java 17 ===\n");
        
        // 1. JNI approach
        demonstrateJNI();
        
        // 2. Unsafe memory access
        demonstrateUnsafeMemory();
        
        // 3. ByteBuffer for native memory
        demonstrateByteBuffer();
        
        // 4. Limitations of traditional approaches
        demonstrateLimitations();
    }
    
    private static void demonstrateJNI() {
        System.out.println("1. JNI (Java Native Interface):");
        System.out.println("  - Requires C/C++ code compilation");
        System.out.println("  - Platform-specific shared libraries (.dll, .so, .dylib)");
        System.out.println("  - Complex build process");
        System.out.println("  - Error-prone memory management");
        
        // Simulate JNI call (would normally be native method)
        System.out.println("  Example: native int calculateSum(int[] array);");
        System.out.println("  Status: Requires external compilation");
        System.out.println();
    }
    
    @SuppressWarnings("removal")
    private static void demonstrateUnsafeMemory() {
        System.out.println("2. Unsafe Memory Access:");
        
        if (unsafe != null) {
            try {
                // Allocate off-heap memory
                long address = unsafe.allocateMemory(1024);
                System.out.println("  Allocated memory at address: 0x" + Long.toHexString(address));
                
                // Write data
                unsafe.putInt(address, 42);
                unsafe.putInt(address + 4, 84);
                
                // Read data
                int value1 = unsafe.getInt(address);
                int value2 = unsafe.getInt(address + 4);
                System.out.println("  Values read: " + value1 + ", " + value2);
                
                // Free memory
                unsafe.freeMemory(address);
                System.out.println("  Memory freed");
                
                System.out.println("  Issues: Unsafe, deprecated, restricted access");
            } catch (Exception e) {
                System.out.println("  Error: " + e.getMessage());
            }
        } else {
            System.out.println("  Unsafe not available (restricted in newer Java versions)");
        }
        System.out.println();
    }
    
    private static void demonstrateByteBuffer() {
        System.out.println("3. ByteBuffer for Native Memory:");
        
        // Direct ByteBuffer (off-heap)
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println("  Direct buffer allocated: " + directBuffer.capacity() + " bytes");
        System.out.println("  Is direct: " + directBuffer.isDirect());
        
        // Write data
        directBuffer.putInt(100);
        directBuffer.putInt(200);
        
        // Read data
        directBuffer.flip();
        int val1 = directBuffer.getInt();
        int val2 = directBuffer.getInt();
        System.out.println("  Values: " + val1 + ", " + val2);
        
        System.out.println("  Limitations: Limited API, no struct support, manual memory management");
        System.out.println();
    }
    
    private static void demonstrateLimitations() {
        System.out.println("4. Traditional Approach Limitations:");
        System.out.println("  - JNI: Complex, platform-specific, build overhead");
        System.out.println("  - Unsafe: Deprecated, restricted, dangerous");
        System.out.println("  - ByteBuffer: Limited functionality, no type safety");
        System.out.println("  - No direct C struct mapping");
        System.out.println("  - Manual memory lifecycle management");
        System.out.println("  - Poor performance for small native calls");
        System.out.println();
    }
}