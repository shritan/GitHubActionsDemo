package com.test.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.joda.time.DateTime;

public class TestJodaTime {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMYYYY");

    public static void main(final String[] args) {
        final LocalDate currentdate = LocalDate.now();
        final String contractMonth = new DateTime(currentdate.toString()).toString("MMMYYYY").toUpperCase();
        System.out.println("contractMonth :: " + contractMonth);
        System.out.println("new DateTime() " + new DateTime());
        final String formatedValue = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMYYYY"));
        System.out.println(formatedValue);

        System.out.println(DateTime.now().toDate());
        System.out.println(new Date());
        final LocalDateTime toolTipLocalDateTime = LocalDateTime.now();
        System.out.println(toolTipLocalDateTime);
        System.out.println(toolTipLocalDateTime.minusSeconds(2));

    }

}
