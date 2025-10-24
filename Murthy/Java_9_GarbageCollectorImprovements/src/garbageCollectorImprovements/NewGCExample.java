package garbageCollectorImprovements;

public class NewGCExample {

	public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String data = new String("Data" + i);
        }		
        System.out.println("Completed GC Example (Java 9+)");


	}

}
