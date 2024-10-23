/**
 *
 */
package com.test.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 */
public class MapCountExp {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Map<String, Integer> map = new HashMap<>();
        map.put("a", 12);
        map.put("b", 3);
        map.put("c", 24);
        System.out.println("Count  " + map.entrySet().stream().mapToInt(Entry::getValue).sum());
        final Integer sum1 = map.values()
            .stream()
            .mapToInt(Integer::valueOf)
            .sum();
        System.out.println(sum1);
        expMap();
    }

    private static void expMap() {
        final Map<String, Integer> hmap = new HashMap<>();
        hmap.put("Apple", 11);
        hmap.put("Orange", 2);
        hmap.put("Kiwi", 3);
        hmap.put("Banana", 4);

        final int sum = hmap.entrySet()
            .stream()
            .filter(t -> !t.getKey().equals("Apple")).mapToInt(Entry::getValue).sum();
        System.out.println("sum " + sum);

    }

}
