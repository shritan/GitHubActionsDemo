/**
 *
 */
package com.test.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class TestSemicoloun {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        final String result = numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining("','"));
        System.out.println(result);
        // Example list of integers

        // Form the SQL IN statement
        final String sqlInStatement = "('" + String.join("','", numbers.stream().map(Object::toString).toArray(String[]::new)) + "')";

        // Print the SQL IN statement
        System.out.println(sqlInStatement);
    }

}
