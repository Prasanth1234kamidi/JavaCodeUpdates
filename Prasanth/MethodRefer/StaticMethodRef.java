package MethodRefer;

import java.util.function.Function;

public class StaticMethodRef {
    public static void main(String[] args) {
        // Lambda
        Function<String, Integer> strLength1 = str -> str.length();

        // Method Reference
        Function<String, Integer> strLength2 = String::length;

        System.out.println(strLength1.apply("Prashanth")); // 9
        System.out.println(strLength2.apply("Java"));      // 4
    }
}
