package com.test.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRegExp {

    public static void main(final String[] args) {
        // final String input = " Sunday, January 15, 2012 at 7:37pm EST";
        final String input = "Oct 14, 2020, 12:00:00 AM";
        // final String regex =
        // "(\\w+,\\s+\\w+\\s+\\d+\\,\\s+\\d+\\s+at\\s+\\d+:\\d+(pm|am)\\s+\\w{3,4})";
        final String regex = "^.*,.*$";
        final Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            System.out.println("true");
            System.out.println(matcher.group(0));
        }
    }

}
