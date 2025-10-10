package MethodRefer;
import java.util.*;

public class ArbitraryMethodRef {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Prashanth", "Ravi", "Anu");

        // Lambda
        names.forEach(name -> System.out.println(name));

        // Method Reference
        names.forEach(System.out::println);
    }
}

