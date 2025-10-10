package ParallelStreams;
import java.util.*;
import java.util.stream.*;

public class StreamComparison {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Sequential Stream:");
        numbers.stream()
               .map(n -> n * 2)
               .forEach(System.out::println);

        System.out.println("\nParallel Stream:");
        numbers.parallelStream()
               .map(n -> n * 2)
               .forEach(System.out::println);
    }
}
