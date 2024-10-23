package com.test.example;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

    public static void main(final String[] args) {
        final Set<String> formatedSet = new HashSet<>();
        System.out.println(formatedSet.add("00:00-23:00"));
        System.out.println(formatedSet.add("00:00-23:00"));
    }

}
