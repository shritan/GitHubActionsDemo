package com.test.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestListEmpty {

    public static void main(final String[] args) {
        final List<String> list = null;
        final List<String> list2 = new ArrayList<>();
        list2.stream().forEach(t -> System.out.println("value :: " + t));
        final List<String> list3 = Arrays.asList("RODOTC", "RDOTC");
        if (list3.contains("NONE")) {
            System.out.println("List Contains ");
        }
        if (list3.contains("")) {
            System.out.println("List Not Contains ");
        }

    }

}
