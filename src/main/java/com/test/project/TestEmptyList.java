package com.test.project;

import java.util.List;
import java.util.Objects;

public class TestEmptyList {

    public static void main(final String[] args) {
        /*
         * final List<String> list = null; if (list.isEmpty()) {
         * System.out.println("List is Empty"); }
         */
        final List<String> list1 = null;

        final boolean isNullOrEmpty = Objects.nonNull(list1);

        System.out.println(isNullOrEmpty);
    }

}
