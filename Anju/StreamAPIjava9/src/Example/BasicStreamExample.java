package Example;

import java.util.*;
import java.util.stream.*;
public class BasicStreamExample 
{
	    public static void main(String[] args) {
	        
	        // 1. Stream.ofNullable()
	        System.out.println("1. Stream.ofNullable()");
	        String value = null;
	        Stream.ofNullable(value).forEach(System.out::println); // Prints nothing (empty stream)
	        Stream.ofNullable("Hello").forEach(System.out::println); // Prints "Hello"
	        
	        // 2. takeWhile()
	        System.out.println("\n2. takeWhile()");
	        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 0, 6, 7);
	        numbers.stream()
	               .takeWhile(n -> n > 0) // Take until we hit zero
	               .forEach(System.out::println); // Prints 1,2,3,4,5

	        // 3. dropWhile()
	        System.out.println("\n3. dropWhile()");
	        numbers.stream()
	               .dropWhile(n -> n > 0) // Skip until we hit non-positive
	               .forEach(System.out::println); // Prints 0,6,7

	        // 4. iterate() with Predicate
	        System.out.println("\n4. iterate() with Predicate");
	        Stream.iterate(1, n -> n <= 10, n -> n + 2) // from 1 to 10, step 2
	              .forEach(System.out::println); // Prints 1,3,5,7,9

	        // 5. ofNullable() in combination with Optional
	        System.out.println("\n5. ofNullable() + Optional");
	        Optional<String> optionalName = Optional.ofNullable("John");
	        optionalName.stream().forEach(System.out::println); // Prints "John"

	        Optional<String> emptyOptional = Optional.ofNullable(null);
	        emptyOptional.stream().forEach(System.out::println); // Prints nothing

	        // 6. Stream methods returning Optional
	        System.out.println("\n6. findFirst() with Optional");
	        List<String> names = List.of("Alice", "Bob", "Charlie");
	        names.stream().findFirst().ifPresent(System.out::println); // Prints "Alice"

	        // 7. Collectors Enhancements
	        System.out.println("\n7. Collectors.filtering() and flatMapping()");

	        // Collectors.filtering()
	        Map<Integer, List<String>> grouped = names.stream()
	            .collect(Collectors.groupingBy(String::length,
	                    Collectors.filtering(n -> n.startsWith("A"), Collectors.toList())));
	        System.out.println(grouped); // Groups by length, filters only "A..."

	        // Collectors.flatMapping()
	        List<List<String>> nested = List.of(List.of("x", "y"), List.of("z"));
	        List<String> flat = nested.stream()
	            .collect(Collectors.flatMapping(List::stream, Collectors.toList()));
	        System.out.println(flat); // Prints [x, y, z]
	    }
}

