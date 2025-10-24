package unifiedJVMLogging;

import java.util.ArrayList;
import java.util.List;

public class UnifiedLoggingExample {

	public static void main(String[] args) {
		System.out.println("Program started...");

        List<String> data = new ArrayList<>();

        // Create objects continuously to trigger Garbage Collection
        for (int i = 0; i < 100000; i++) {
            data.add(new String("Object-" + i));

            // Remove some elements periodically to create GC pressure
            if (data.size() >= 500 && i % 1000 == 0) {
                data.subList(0, 500).clear();  // creates GC pressure
            }
        }
        System.out.println("Program completed!");
	}
}
