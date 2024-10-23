package com.test.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConvertLocalDateToLocalDateTime {
    public static void main(final String[] args) {
        final LocalDate date = LocalDate.parse("2017-06-22");
        System.out.println("LocalDate is: " + date);

        /*
         * Converting the LocalDate to LocalDateTime using atStartOfDay() method. This method adds
         * midnight time (start of the day time) with the local date.
         */
        final LocalDateTime localDateTime1 = date.atStartOfDay();
        System.out.println("LocalDateTime Start of the Day: " +
                localDateTime1);

        /*
         * The method atTime(int hour, int minutes) is useful when we need to append the exact hour
         * and minutes to the date to convert it into a LocalDateTime. The time is in 24 hour format
         */
        final LocalDateTime localDateTime2 = date.atTime(20, 16);
        System.out.println("LocalDateTime for given hour and min: " +
                localDateTime2);

        /*
         * atTime(int hour, int minutes, int seconds) hour - the hour-of-day, value range from 0 to
         * 23. minute - the minute-of-hour, value range from 0 to 59. second - the second-of-minute,
         * value range from 0 to 59.
         */
        final LocalDateTime localDateTime3 = date.atTime(20, 16, 40);
        System.out.println("LocalDateTime for given hour, min, seconds: " +
                localDateTime3);

        /*
         * atTime(int hour, int minutes, int seconds, int nanoseconds) hour - the hour-of-day, value
         * range from 0 to 23. minute - the minute-of-hour, value range from 0 to 59. second - the
         * second-of-minute, value range from 0 to 59. nanoOfSecond - the nano-of-second, value
         * range from 0 to 999,999,999
         */
        final LocalDateTime localDateTime4 = date.atTime(20, 16, 40, 1600);
        System.out.println("LocalDateTime for given hr, min, sec, nanoseconds: " +
                localDateTime4);
    }
}
