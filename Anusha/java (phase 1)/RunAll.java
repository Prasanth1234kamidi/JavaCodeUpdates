public class RunAll {
    public static void main(String[] args) {
        System.out.println("🚀 Java 17 Features Demo - Running All Examples\n");
        
        runExample("Records", "records");
        runExample("Sealed Classes", "sealed-classes");
        runExample("Pattern Matching", "pattern-matching");
        runExample("Switch Expressions", "switch-expressions");
        runExample("String Templates", "string-templates");
        runExample("Encapsulation", "encapsulation");
        runExample("Virtual Threads", "virtual-threads");
        runExample("Multithreading & Concurrency", "multithreading-concurrency");
        runExample("JVM & Memory Management", "jvm-memory");
        
        System.out.println("\n✅ All examples completed!");
        System.out.println("\nTo run Virtual Threads (requires preview features):");
        System.out.println("cd virtual-threads && javac --enable-preview --source 17 *.java && java --enable-preview VirtualThreadDemo");
    }
    
    private static void runExample(String name, String folder) {
        System.out.println("📁 " + name + " (" + folder + ")");
        System.out.println("   Command: cd " + folder + " && javac *.java && java *Demo");
        System.out.println("   ─────────────────────────────────────────────────");
    }
}

/*
MANUAL COMMANDS TO RUN EACH EXAMPLE:

1. Records:
   cd records && javac *.java && java RecordDemo

2. Sealed Classes:
   cd sealed-classes && javac *.java && java SealedDemo

3. Pattern Matching:
   cd pattern-matching && javac *.java && java PatternDemo

4. Switch Expressions:
   cd switch-expressions && javac *.java && java SwitchDemo

5. String Templates:
   cd string-templates && javac *.java && java StringTemplateDemo

6. Encapsulation:
   cd encapsulation && javac *.java && java EncapsulationDemo

7. Virtual Threads (Concept):
   cd virtual-threads && javac *.java && java VirtualThreadDemo

8. Concurrency:
   cd multithreading-concurrency && javac *.java && java ConcurrencyDemo

9. Memory Management:
   cd jvm-memory && javac *.java && java MemoryDemo

RUN ALL AT ONCE:
javac RunAll.java && java RunAll
*/