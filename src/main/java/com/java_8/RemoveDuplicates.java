package com.java_8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(final String[] args) {
        // Approch 1 if we implement hashcode and equals
        final List<Person> persons =
            new ArrayList<>(List.of(new Person(1, "John", "Doe"), new Person(2, "Reedy", "John"), new Person(1, "Mohan", "Doe")));

        final List<Person> filteredList = persons.stream().distinct().toList();
        filteredList.stream().forEach(s -> System.out.println(s));
        System.out.println("===========================================");
        // aproach 2 by using list.contains it will not work if we dont implement hashcode and
        // equals final
        final List<Person> filteredList2 = persons.stream().collect(ArrayList::new, (list, item) -> {
            if (!list.contains(item)) {
                list.add(item);
            }
        }, ArrayList::addAll);
        filteredList2.forEach(System.out::println);
        System.out.println("===========================================");
        // approach 3 by using toMap to get the unique values
        final List<Person> filteredList3 = persons.stream()
            .collect(Collectors.toMap(Person::getId, Function.identity(), (oldValue, newValue) -> oldValue)).values().stream().toList();
        filteredList3.stream().forEach(System.out::println);
        System.out.println("===========================================");
        // approach 4 by using distinctByKey
        persons.stream().filter(StreamUtils.distinctByKey(Person::getId)).forEach(System.out::println);
        System.out.println("***********************************");

        // Approach 5 by using Comparator.comparing
        final Comparator<Person> personComparator = Comparator.comparing(Person::getId).thenComparing(Person::getLastName);
        final List<Person> filteredList5 =
            persons.stream().sorted(personComparator).collect(Collectors.toCollection(() -> new TreeSet<>(personComparator))).stream()
                .toList();
        filteredList5.stream().forEach(System.out::println);

    }
}
