package com.java_8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CodingExp {

    public static void main(final String[] args) {
        final List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7);
        list.stream().mapToInt(Number::intValue).sum();
        final Optional<Integer> max = list.stream().max((o1, o2) -> {
            return Integer.compare(o1, o2);
        });
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        final List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);
        // filter the even numbers
        final long evenNum = list.stream().filter(t -> t % 2 != 0).count();
        System.out.println(evenNum);
        final String result = fruits.stream().collect(Collectors.joining(","));
        System.out.println(result);
        final Set<String> set = fruits.stream().collect(Collectors.toSet());
        System.out.println(set);
    }

}
