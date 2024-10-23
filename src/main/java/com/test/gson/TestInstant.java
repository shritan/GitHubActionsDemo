package com.test.gson;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class TestInstant {
    public static void main(final String[] args) {
        System.out.println(Instant.now());
        final int day = Instant.now().atOffset(ZoneOffset.UTC).getDayOfMonth();
        System.out.println(Instant.ofEpochSecond(1000));
        System.out.println(day);

        final Calendar c1 = Calendar.getInstance();
        // Set Month
        // MONTH starts with 0 i.e. ( 0 - Jan)
        c1.set(Calendar.MONTH, 00);
        // Set Date
        c1.set(Calendar.DATE, 30);
        // Set Year
        c1.set(Calendar.YEAR, 2019);
        c1.set(Calendar.HOUR, 0);
        // Creating a date object
        // with specified time.
        c1.set(2019, 01, 23, 0, 00, 00);
        final Date dateOne = c1.getTime();
        final Instant inst = dateOne.toInstant();

        System.out.println("Original Date: " + dateOne.toString());
        System.out.println("Instant: " + inst);
    }
}
