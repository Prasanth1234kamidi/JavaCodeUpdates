public class MemoryDemo {
    public static void main(String[] args) {
        System.out.println("=== JVM Memory Demo ===");
        
        MemoryManagementExamples.memoryInfo();
        System.out.println();
        
        MemoryManagementExamples.gcInfo();
        System.out.println();
        
        MemoryManagementExamples.efficientObjectCreation();
        MemoryManagementExamples.stringInterning();
        MemoryManagementExamples.weakReferences();
    }
}

// Run: javac *.java && java MemoryDemo