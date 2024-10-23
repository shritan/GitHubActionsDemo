package com.java_8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class HashSetExp {

    public static void main(final String[] args) {
        final Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println("Set Value " + set);

        final List<String> list = new CopyOnWriteArrayList<>();
        list.add(null);
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        final Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            final String value = it.next();
            list.remove("Orange");
            System.out.println(value);

        }
    }

}
