package com.test.preparation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class TestMapNSet {

    public static void main(final String[] args) {
        final List<Employee> employees = List.of(
            new Employee(1, "Alice", "Smith"),
            new Employee(2, "Bob", "Johnson"),
            new Employee(3, "Charlie", "Williams"),
            new Employee(3, "Charlie", "Johnson"));
        final Set<Employee> employeeSet = employees.stream().collect(Collectors.toSet());
        System.out.println("Set Values");
        employeeSet.forEach(System.out::println);
        System.out.println("------------------------------------------");
        final Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(Employee::getEmployeedId, t -> t, (t, u) -> u));
        map.forEach((t, u) -> System.out.println(u));
        System.out.println("Map Value With GroupBy");
        final Map<Integer, List<Employee>> employeeMapGroupBy = employees.stream().collect(Collectors.groupingBy(Employee::getEmployeedId));
        employeeMapGroupBy.forEach((t, u) -> System.out.println("Key " + t + ", Value " + u));

        // Find the duplicate keys in list

        final List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        final Map<String, Long> duplicateMap = list.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println("DuplicateList " + duplicateMap.entrySet().stream().filter(t -> t.getValue() > 1).map(Entry::getKey).toList());
        System.out.println("------------------------------------------");
        System.out.println("Duplicate M<ap" + duplicateMap);
        System.out.println("------------------------------------------");
        System.out.println("Entry Set" + duplicateMap.entrySet());
        final Set<String> duplicates = list.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))// get the Map like
                                                                          // {apple=1}
            .entrySet()// get entry set like orange=1, banana=2, apple=3
            .stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
        System.out.println(duplicates);

        System.out.println("No Duplicate Value");
        System.out.println(duplicateMap.entrySet().stream().filter(entrySet -> entrySet.getValue() == 1).map(Entry::getKey).toList());

        final Set<String> set1 = list.stream().map(t -> {
            final Set<String> set = new HashSet<>();
            set.add(t);
            return set;
        }).flatMap(t -> t.stream()).collect(Collectors.toSet());
        System.out.println("Set1 " + set1);
    }

}
