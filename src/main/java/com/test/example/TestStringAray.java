package com.test.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

public class TestStringAray {

    public static void main(final String[] args) {
        final String names = "PDOTC,PODOTC,RDOTC,RODOTC";

        final String[] namesArray = names.split(",");
        /*
         * System.out.println(namesArray.toString()); final String finalOP = String.join(" ",
         * namesArray); System.out.println("final op :: " + finalOP);
         */
        final StringJoiner joiner = new StringJoiner("','", "'", "'");
        final List<String> list = new ArrayList<>();
        for (final String string : namesArray) {
            // joiner.add(string);
            list.add("'" + StringUtils.join(string) + "'");
        }
        final String join = "'" + StringUtils.join(namesArray, "','") + "'";
        /*
         * System.out.println(join); System.out.println(Arrays.asList(joiner.toString()));
         */
        System.out.println(list);
    }

}
