package com.java_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public class HashMapSorting {

    public static void main(final String[] args) {
        final Map<String, Integer> codenames = new HashMap<>();
        codenames.put("Sparkler", 4);
        codenames.put("Playground", 2);
        codenames.put("Kestrel", 3);
        codenames.put("Merlin", 3);
        codenames.put("Dolphin", 1);

        // codenames.entrySet().stream().forEach(t -> System.out.println(t.getKey() + "===>" +
        // t.getValue()));
        System.out.println("-----------------Natural Orderd by Keys-----------------------");
        final Map<String, Integer> sortedMap = new TreeMap<>(codenames);
        sortedMap.entrySet().stream().forEach(t -> System.out.println(t.getKey() + "===>" +
                t.getValue()));
        final Map<String, Integer> sortedMapByValue = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        System.out.println("-----------------Sort With Object Key Decending------------------------");
        sortedMapByValue.putAll(codenames);
        sortedMapByValue.entrySet().stream().forEach(t -> System.out.println(t.getKey() + "===>"
                + t.getValue()));
        System.out.println("------------------Jav8---------------------------");
        // (o1, o2) -> o1.getValue().compareTo(o2.getValue())
        final Map<String, Integer> sortedMapByValue1 =
            codenames.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        sortedMapByValue1.entrySet().forEach(t -> System.out.println(t.getKey() + "===>" + t.getValue()));
        // sortBy7(codenames);

        List<Integer> valueList = new ArrayList<>(codenames.values());
        valueList.sort(Comparable::compareTo);
        // Collections.sort(valueList);
        // System.out.println(valueList);

        valueList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(valueList)) {
            System.out.println("List is not empty or size is not zero");
        } else {
            System.out.println("List is  empty or size is  zero");
        }

    }

    static void sortBy7(final Map<String, Integer> mapVaues) {
        final Comparator<Entry<String, Integer>> valueComparator = (o1, o2) -> o1.getValue().compareTo(o2.getValue());
        // Sort method needs a List, so let's first convert Set to List in Java
        final List<Entry<String, Integer>> listOfEntries = new ArrayList<>(mapVaues.entrySet());
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        final LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        for (final Entry<String, Integer> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        System.out.println("HashMap after sorting entries by values ");
        System.out.println("-------------------------------------------------------------------------");
        sortedByValue.entrySet().forEach(t -> System.out.println(t.getKey() + "===>" + t.getValue()));

    }
    /*
     * codenames.put("JDK 1.1.4", "Sparkler"); codenames.put("J2SE 1.2", "Playground");
     * codenames.put("J2SE 1.3", "Kestrel"); codenames.put("J2SE 1.4", "Merlin");
     * codenames.put("J2SE 5.0", "Tiger"); codenames.put("Java SE 6", "Mustang");
     * codenames.put("Java SE 7", "Dolphin"); codenames.put("Java SE 8", "Dolphin");
     */

}
