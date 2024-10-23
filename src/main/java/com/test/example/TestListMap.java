/**
 *
 */
package com.test.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class TestListMap {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "abc.com"));
        list.add(new Hosting(2, "linode.com"));
        list.add(new Hosting(1, "mkyong.com"));
        list.add(new Hosting(1, "Mohan"));

        // key = id, value - websites
        final Map<Integer, List<Hosting>> result1 = list.stream().collect(
            Collectors.groupingBy(Hosting::getId));

        System.out.println("Result 1 : " + result1);

        /*
         * // key = name, value - websites final Map<String, Long> result2 = list.stream().collect(
         * Collectors.toMap(Hosting::getName, Hosting::getWebsites));
         *
         * System.out.println("Result 2 : " + result2);
         */
        // Same with result1, just different syntax

        // key = id, value = name
        final Map<Integer, String> result3 = list.stream().collect(
            Collectors.toMap(Hosting::getId, Hosting::getName, (t, u) -> u));

        System.out.println("Result 3 : " + result3);

        System.out.println(result3.getOrDefault(4, "23"));

    }

}
