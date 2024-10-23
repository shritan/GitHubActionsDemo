package com.test.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestList {

    public static void main(final String[] args) {

        final List<CrewMemberGets> list1 = new ArrayList<>();
        list1.add(CrewMemberGets.COCKPIT_QUALIFICATION);
        list1.add(CrewMemberGets.BID_STATUS);

        final List<CrewMemberGets> list2 = new ArrayList<>();
        list2.add(CrewMemberGets.BID_STATUS);
        list2.add(CrewMemberGets.DFP_DETAILS);
        list2.add(CrewMemberGets.COCKPIT_QUALIFICATION);

        /*
         * final List<String> list1 = Arrays.asList("apple", "banana", "orange"); final List<String>
         * list2 = Arrays.asList("apple", "banana", "orange");
         *
         */
        final boolean isSame = org.apache.commons.collections4.CollectionUtils.isEqualCollection(list1, list2);
        System.out.println("isSame :: " + isSame);

        final List<CrewMemberGets> differences = list2.stream()
            .peek(t -> System.out.println("Obj.." + t))
            // .filter(t -> list1.stream().allMatch(t1 -> t1.value().equals(t.value())))
            .filter(element -> !list1.contains(element))
            .toList();

        /*
         * if (isEqual) { System.out.println("Lists are equal"); } else {
         * System.out.println("Lists are not equal"); }
         */
        System.out.println(differences);

        final Set<Integer> items = new HashSet<>();
        final List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        final Set<Integer> item = list.stream().filter(t -> !items.add(t)).collect(Collectors.toSet());
        System.out.println("Duplicate Items .." + item);
    }

}
