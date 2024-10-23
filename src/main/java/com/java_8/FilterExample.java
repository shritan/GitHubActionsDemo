package com.java_8;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(final String[] args) {
        final List<Integer> numbers = Arrays.asList(2, 4);
        // Filter out even numbers
        numbers.stream()
            .filter(n -> n % 2 != 0 || n % 2 == 0) // Predicate: true for odd numbers
            .peek(System.out::println) // Intermediate operation
            .forEach(System.out::println);// Terminal operation;

    }
}
