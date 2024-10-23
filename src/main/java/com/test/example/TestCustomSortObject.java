package com.test.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestCustomSortObject {

    public static void main(final String[] args) {
        final List<Student> studentList = new ArrayList<>();

        // add student object to List
        studentList.add(new Student(1, "Arun", 67.34, 2));
        studentList.add(new Student(2, "Sethu", 88.58, 1));
        studentList.add(new Student(3, "Ajith", 55.74, 4));
        studentList.add(new Student(4, "Vikcy", 61.32, 3));
        studentList.add(new Student(1, "Arun", 67.36, 2)); // duplicate Arun

        // pretty print
        System.out.println("Original Student list with duplicates :");
        studentList.forEach(System.out::println);

        // Java 8 - Collector.toCollection()
        final List<Student> uniqueStudentSet = studentList
            .stream() // get stream for original list
            .collect(Collectors.toCollection(// distinct elements stored into new SET
                () -> new TreeSet<>(Comparator.comparing(Student::getId))))
            .stream().toList(); // Id comparison

        // pretty print
        System.out.println("New SET with unique Student objects in natural order of Id :");
        uniqueStudentSet.forEach(System.out::println);

        // Java 8 - sorting in ascending order of Student's Rank
        final List<Student> sortedList = uniqueStudentSet
            .stream() // get stream for unique SET
            .sorted(Comparator.comparing(Student::getRank).reversed()) // rank comparing
            .toList(); // elements stored to new list

        // pretty print
        System.out.println("Sorted according to ascending order of Student's Rank ");
        sortedList.forEach(System.out::println);
        System.out.println("Sorted according to decending order of Student's Rank ");
        Collections.sort(studentList, Comparator.comparing(Student::getId).reversed());
        studentList.forEach(System.out::println);
        studentList.stream().map(Student::getId).collect(Collectors.toSet()).forEach(System.out::print);
    }

}
