package com.test.preparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Employee1 implements Comparable<Employee1> {
    private final int id;

    private final String name;

    public Employee1(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(final Employee1 other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class Main {
    public static void main(final String[] args) {
        final List<Employee1> employees = Arrays.asList(
            new Employee1(3, "John"),
            new Employee1(1, "Alice"),
            new Employee1(2, "Bob"));

        // Sorting using Comparable
        Collections.sort(employees);

        System.out.println(employees);
    }
}
