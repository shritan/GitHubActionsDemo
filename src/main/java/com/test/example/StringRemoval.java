package com.test.example;

public class StringRemoval {

    public static void main(final String[] args) {
        String str =
            "{\r\n    \"reserveAvailabilityDetails\\\": [\r\n  ";
        str = str.replace("\\r\\n", "").replace("\\t", "");
        str = str.replaceAll("[\\t ]", "");
        System.out.println(str);

        final String str1 = "Oct 14 2020 12:00:00 AM";
        final String[] strings = str1.split(",");
        System.out.println("length == " + strings.length);
    }

}
