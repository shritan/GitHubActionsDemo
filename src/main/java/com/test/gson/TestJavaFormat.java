package com.test.gson;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class TestJavaFormat {

    public static void main(final String[] args) {
        final Date date = new Date();
        LocalDateTime localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        System.out.println(localDateTime);

        localDateTime =
            Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);

        final Date in = new Date();
        final LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        final Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(Date.from(ldt.toInstant(ZoneOffset.UTC)));
        ;

    }

    public static LocalDateTime convertToLocalDateViaMilisecond(final Date dateToConvert) {

        // Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate()
        // return
        // Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        /*
         * return dateToConvert.toInstant() .atZone(ZoneId.systemDefault()) .toLocalDate();
         */
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault())
            .toLocalDateTime();

    }
}
