package com.test.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(final String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 8);
        final Set<Integer> set = numbers.stream().distinct().collect(Collectors.toSet());
        System.out.println(set);
        final Set<Integer> set1 = new HashSet<>();
        final Set<Integer> result = numbers.stream().filter(t -> !set1.add(t)).collect(Collectors.toSet());
        System.out.println("result" + result);
        // Use Java 8 Streams to find duplicate elements
        final Map<Integer, Long> elementCounts = numbers.stream()
            .collect(Collectors.groupingBy(
                // Function to extract the element itself for grouping
                Integer::intValue,
                // Count the occurrences of each element in the list
                Collectors.counting()));
        System.out.println(elementCounts);
        // Filter for elements with count > 1 (i.e., duplicates)
        final List<Integer> duplicates = elementCounts.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        // Print the duplicate elements
        System.out.println("Duplicate elements: " + duplicates);

        List<String> list = Arrays.asList("JAN", "JAN", "FEB");
        list = list.stream().distinct().toList();
        System.out.println(list);
    }
}
