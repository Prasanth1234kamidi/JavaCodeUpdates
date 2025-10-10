package MethodRefer;
import java.util.*;

public class MethodRefStream {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango", "Banana", "Apple");

        // Lambda
        fruits.stream().map(f -> f.toUpperCase()).forEach(f -> System.out.println(f));

        // Method Reference
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
