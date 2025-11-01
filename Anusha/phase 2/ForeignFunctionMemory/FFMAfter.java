import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

/**
 * Foreign Function & Memory After Java 17 (Updated for Java 21+)
 * Shows new Foreign Function & Memory API (Standard in Java 21+)
 * Note: Requires --enable-native-access=ALL-UNNAMED
 */
public class FFMAfter {
    public static void main(String[] args) {
        System.out.println("=== Foreign Function & Memory After Java 17 ===\n");
        
        try {
            // 1. Memory segments
            demonstrateMemorySegments();
            
            // 2. Memory layouts
            demonstrateMemoryLayouts();
            
            // 3. Foreign functions
            demonstrateForeignFunctions();
            
            // 4. Advantages of new API
            demonstrateAdvantages();
            
        } catch (Exception e) {
            System.out.println("FFM API not available or not enabled.");
            System.out.println("Run with: --enable-native-access=ALL-UNNAMED");
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateMemorySegments() {
        System.out.println("1. Memory Segments (Safe Off-Heap Memory):");
        
        try (Arena arena = Arena.ofConfined()) {
            // Allocate native memory
            MemorySegment segment = arena.allocate(1024);
            System.out.println("  Allocated segment: " + segment.byteSize() + " bytes");
            System.out.println("  Address: 0x" + Long.toHexString(segment.address()));
            
            // Write data using memory access
            segment.set(ValueLayout.JAVA_INT, 0, 42);
            segment.set(ValueLayout.JAVA_INT, 4, 84);
            
            // Read data
            int value1 = segment.get(ValueLayout.JAVA_INT, 0);
            int value2 = segment.get(ValueLayout.JAVA_INT, 4);
            System.out.println("  Values: " + value1 + ", " + value2);
            
            System.out.println("  Benefits: Automatic cleanup, bounds checking, type safety");
        } // Automatic cleanup when arena closes
        System.out.println();
    }
    
    private static void demonstrateMemoryLayouts() {
        System.out.println("2. Memory Layouts (Structured Data):");
        
        // Define a C-like struct layout
        StructLayout pointLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("x"),
            ValueLayout.JAVA_INT.withName("y")
        ).withName("Point");
        
        System.out.println("  Point struct layout: " + pointLayout);
        System.out.println("  Size: " + pointLayout.byteSize() + " bytes");
        
        // Create memory segment for the struct
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment pointSegment = arena.allocate(pointLayout);
            
            // Access struct fields using var handles
            VarHandle xHandle = pointLayout.varHandle(MemoryLayout.PathElement.groupElement("x"));
            VarHandle yHandle = pointLayout.varHandle(MemoryLayout.PathElement.groupElement("y"));
            
            // Set values
            pointSegment.set(ValueLayout.JAVA_INT, 0, 10);
            pointSegment.set(ValueLayout.JAVA_INT, 4, 20);
            
            // Get values
            int x = pointSegment.get(ValueLayout.JAVA_INT, 0);
            int y = pointSegment.get(ValueLayout.JAVA_INT, 4);
            System.out.println("  Point coordinates: (" + x + ", " + y + ")");
        }
        System.out.println();
    }
    
    private static void demonstrateForeignFunctions() {
        System.out.println("3. Foreign Functions (Direct C Library Calls):");
        
        try {
            // Look up C standard library
            Linker linker = Linker.nativeLinker();
            SymbolLookup stdlib = linker.defaultLookup();
            
            // Look up strlen function
            MemorySegment strlenAddr = stdlib.find("strlen").orElse(null);
            if (strlenAddr != null) {
                // Create method handle for strlen
                MethodHandle strlen = linker.downcallHandle(
                    strlenAddr,
                    FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
                );
                
                // Create a C string
                try (Arena arena = Arena.ofConfined()) {
                    MemorySegment cString = arena.allocateUtf8String("Hello, FFM!");
                    
                    // Call strlen
                    long length = (long) strlen.invokeExact(cString);
                    System.out.println("  strlen(\"Hello, FFM!\") = " + length);
                }
            } else {
                System.out.println("  strlen function not found");
            }
            
            System.out.println("  Benefits: No JNI, no compilation, type-safe, performant");
        } catch (Throwable e) {
            System.out.println("  Foreign function call failed: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateAdvantages() {
        System.out.println("4. FFM API Advantages:");
        System.out.println("  ✓ No JNI boilerplate or compilation");
        System.out.println("  ✓ Type-safe memory access");
        System.out.println("  ✓ Automatic memory management with scopes");
        System.out.println("  ✓ Direct C struct mapping");
        System.out.println("  ✓ Better performance than JNI for small calls");
        System.out.println("  ✓ Bounds checking and memory safety");
        System.out.println("  ✓ Platform-independent (no native compilation)");
        System.out.println("  ✓ Deterministic cleanup");
        System.out.println();
        
        System.out.println("Note: This was an incubator API in Java 17");
        System.out.println("Standard API available in Java 21+ (current version)");
    }
}