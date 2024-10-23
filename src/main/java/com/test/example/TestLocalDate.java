package com.test.example;

import java.time.LocalDate;

public class TestLocalDate {

    public static void main(final String[] args) {
        final LocalDate rapDate = LocalDate.parse("2024-07-03");
        System.out.println("Rap Date " + rapDate);
        final LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date " + currentDate);
        // get date for previous day
        final LocalDate previousDate = currentDate.minusDays(1);
        System.out.println("Previous Date" + previousDate);
        if (rapDate.isEqual(currentDate) || rapDate.isBefore(previousDate)) {
            System.out.println("Hello");
        }
        // System.out.println(between(currentDate.plusDays(1), previousDate, currentDate));
    }

    public static boolean between(final LocalDate toCheck, final LocalDate beforeDate, final LocalDate afterDate) {
        if (null != toCheck && null != beforeDate && (toCheck.isAfter(beforeDate) || toCheck.equals(beforeDate))
                && null != afterDate && (toCheck.isBefore(afterDate) || toCheck.equals(afterDate))) {
            return true;
        }
        return false;
    }
}
