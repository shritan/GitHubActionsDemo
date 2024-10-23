package com.java_8;

import java.util.Arrays;
import java.util.List;

public class TestDistinct {

    public static void main(final String[] args) {
        final List<Integer> list = Arrays.asList(3, 5, 6, 3);
        final List<Integer> disIntegers = list.stream().distinct().toList();
        System.out.println(disIntegers);

    }

}
