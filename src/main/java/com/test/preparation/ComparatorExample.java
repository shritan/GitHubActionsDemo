package com.test.preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(final String[] args) {
        final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(300, "Charlie", "Smith"),
            new Employee(1000, "Bob", "Johnson"),
            new Employee(300, "Alice", "Johnson")));
        Collections.sort(employees, Comparator.comparing(Employee::getEmployeedId));
        employees.forEach(System.out::println);
        employees.add(new Employee(200, "John", "Doe"));
        employees.sort(Comparator.comparing(Employee::getEmployeedId));
        employees.forEach(System.out::println);

    }

}
