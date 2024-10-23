package com.test.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.test.gson.Employee;

public class TestDuplicates {
    private static final List<Integer> dbList = Arrays.asList(100, 101, 102, 103, 104, 105);

    private static final List<Integer> uiReqList = Arrays.asList(102, 103, 107);

    public static void main(final String[] args) {
        final Employee[] employees = new Employee[] {
            new Employee(23, "John"), new Employee(26, "Steve"),
            new Employee(33, "Frank"), new Employee(43, "Earl"),
            new Employee(23, "Jessica"), new Employee(33, "Pearl") };
        final List<Employee> employee = Arrays.asList(new Employee(1, "John"), new Employee(1, "Bob"), new Employee(2, "Alice"));
        // employee.forEach(t -> System.out.println(t));

        final Collection<Employee> employee1 =
            employee.stream().collect(Collectors.toConcurrentMap(Employee::getId, Function.identity(), (p, q) -> q)).values();
        // employee1.forEach(System.out::print);
        /*
         * final List<Employee> withoutDupes = employee.stream() .distinct()
         * .collect(Collectors.toList()); System.out.println(withoutDupes.size());
         * withoutDupes.forEach(System.out::print);
         */
        // final Comparator<Integer> c = (a, b) -> Integer.compare(a, b);
        final List<Employee> employeesList = Arrays.asList(employees);
        employeesList.sort(Comparator.comparingInt(Employee::getId).thenComparing(Employee::getName));
        // employeesList.forEach(System.out::println);

        final TreeSet<Employee> outputList = new TreeSet<>(Comparator.comparing(Employee::getId));
        System.out.println(outputList);
        outputList.addAll(employeesList);
        System.out.println("outputList : " + outputList.size());
        System.out.println("outputList : " + outputList);

        final List<Integer> differences = dbList.stream()
            .filter(element -> !uiReqList.contains(element))
            .toList();
        System.out.println("Difff List .." + differences);
    }

}
