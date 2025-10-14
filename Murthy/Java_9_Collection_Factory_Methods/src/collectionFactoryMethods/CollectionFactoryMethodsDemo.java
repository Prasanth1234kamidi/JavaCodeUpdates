package collectionFactoryMethods;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactoryMethodsDemo {

	public static void main(String[] args) {
		
		List<String> fruits = List.of("Apple", "Banana", "Mango");
        System.out.println("Fruits List: " + fruits);
       
        // fruits.add("Orange"); // ❌ UnsupportedOperationException
        // fruits.set(0, "Guava"); // ❌ UnsupportedOperationException


        
        Set<String> countries = Set.of("India", "USA", "UK");
        System.out.println("Countries Set: " + countries);
       
        // Set.of("A", "B", "A"); // ❌ IllegalArgumentException (duplicate)
        // Set.of("X", null); // ❌ NullPointerException
       
        
        Map<String, Integer> marks = Map.of("Maths", 90, "Science", 85, "English", 92);
        System.out.println("Marks Map: " + marks);
       
        // marks.put("History", 88); // ❌ UnsupportedOperationException
        // Map.of("A", 1, "A", 2); // ❌ IllegalArgumentException (duplicate key)
        // Map.of("A", null); // ❌ NullPointerException

        

        
        Map<String, String> codes = Map.ofEntries(
            Map.entry("IN", "India"),
            Map.entry("US", "United States"),
            Map.entry("JP", "Japan"),
            Map.entry("CA", "Canada")
        );
        
        System.out.println("Country Codes Map: " + codes);
        

        

        
        Set<String> USER_ROLES = Set.of("ADMIN", "USER", "GUEST");

        String inputRole = "ADMIN";
        if (USER_ROLES.contains(inputRole)) {
            System.out.println("Access granted for role: " + inputRole);
        } 
        else {
            System.out.println("Access denied for role: " + inputRole);
        }
        
	}

}
