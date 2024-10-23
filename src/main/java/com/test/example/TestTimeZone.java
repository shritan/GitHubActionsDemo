/**
 *
 */
package com.test.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.stream.Stream;

/**
 *
 */
public class TestTimeZone {

    /**
     * @param args
     */
    static String YYYY_MM_DD_HH_MM_DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public static void main(final String[] args) {
        // LocalDate.ofInstant(Calendar.getInstance().getTimeZone(), ZoneId.systemDefault());

        final LocalDate localDate = LocalDate.now();
        System.out.println("localDate" + localDate);
        // localDate = localDate.minusMinutes(20);
        System.out.println(parseDate("2024-12-23"));
        System.out.println(parseDate("12/23/2024"));
        System.out.println(parseDate("23-12-2024"));
        // System.out.println(parseDate("2024-12-24 23:00"));
        System.out.println(convertStringToLocalDate("2024-12-23 12:00", YYYY_MM_DD_HH_MM_DATE_FORMAT));

        final DateTimeFormatter parser = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                // .appendLiteral(' ')
                // .append(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                .toFormatter(Locale.ENGLISH);

        // Test

        Stream.of("2015-05-09 00:10:23.123456789",
            "2015-05-09 00:10:23.12345678",
            "2015-05-09 00:10:23.1234567",
            "2015-05-09 00:10:23.123456",
            "2015-05-09 00:10:23.12345",
            "2015-05-09 00:10:23.1234",
            "2015-05-09 00:10:23.123",
            "2015-05-09 00:10:23.12",
            "2015-05-09 00:10:23.1",
            "2015-05-09 00:10:23.1",
            "2015-05-09 00:10:23",
            "2015-05-09 00:10"
                )
        .map(s -> LocalDate.parse(s, parser)).forEach(System.out::println);

    }


    public static LocalDate parseDate(final String date) {
        final DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter
                .ofPattern("[MM/dd/yyyy]" + "[dd-MM-yyyy]" + "[yyyy-MM-dd]" + "[yyyy-MM-dd HH:mm]"));
        final DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
        return LocalDate.parse(date, dateTimeFormatter);
    }

    public static LocalDate convertStringToLocalDate(final String dateString, final String datePattern) {
        final java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return LocalDate.parse(dateString, formatter);
    }
}
