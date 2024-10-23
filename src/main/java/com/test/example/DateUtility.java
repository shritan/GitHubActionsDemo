package com.test.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtility {
    public static Date parseDate(final String inputDate) {

        Date outputDate = null;
        final String[] possibleDateFormats =
            {
                "yyyy.MM.dd G 'at' HH:mm:ss z",
                "EEE, MMM d, ''yy",
                "h:mm a",
                "hh 'o''clock' a, zzzz",
                "K:mm a, z",
                "yyyyy.MMMMM.dd GGG hh:mm aaa",
                "EEE, d MMM yyyy HH:mm:ss Z",
                "yyMMddHHmmssZ",
                "YYYY-'W'ww-u",
                "EEE, dd MMM yyyy HH:mm:ss z",
                "EEE, dd MMM yyyy HH:mm zzzz",
                "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
                "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
                "yyyy-MM-dd'T'HH:mm:ssZ",
                "yyyy-MM-dd'T'HH:mm:ss.SSSzzzz",
                "yyyy-MM-dd'T'HH:mm:sszzzz",
                "yyyy-MM-dd'T'HH:mm:ss z",
                "yyyy-MM-dd'T'HH:mm:ssz",
                "yyyy-MM-dd'T'HH:mm:ss",
                "yyyy-MM-dd'T'HHmmss.SSSz",
                "yyyy-MM-dd",
                "yyyyMMdd",
                "dd/MM/yy",
                "dd/MM/yyyy",
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd HH:mm:ssZ",
                "yyyy-MM-dd HH:mm:ss.SSSzzzz",
                "yyyy-MM-dd HH:mm:sszzzz",
                "yyyy-MM-dd HH:mm:ss z",
                "yyyy-MM-dd HH:mm:ssz",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HHmmss.SSSz",
                "yyyy-MM-dd HH:mm:ss a",
            };

        try {

            outputDate = DateUtils.parseDate(inputDate, Locale.US, possibleDateFormats);
            System.out.println("inputDate ==> " + inputDate + ", outputDate ==> " + outputDate);
            // System.out.println("inputDate ==> " + inputDate + ", outputDate ==> " +
            // asLocalDate(outputDate));

        } catch (final ParseException e) {
            e.printStackTrace();
        }

        return outputDate;

    }

    public static LocalDate asLocalDate(final java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void main(final String[] args) {

        DateUtility.parseDate("2018-11-18 23:00");
        /*
         * DateUtility.parseDate("20181118"); DateUtility.parseDate("2018-11-18 00:00:00 AM");
         *
         * DateUtility.parseDate("18/11/18"); DateUtility.parseDate("18/11/2018");
         * DateUtility.parseDate("2018.11.18 AD at 12:08:56 PDT"); System.out.println("");
         * DateUtility.parseDate("Wed, Nov 18, '18"); DateUtility.parseDate("12:08 PM");
         * DateUtility.parseDate("12 o'clock PM, Pacific Daylight Time");
         * DateUtility.parseDate("0:08 PM, PDT"); DateUtility.parseDate("02018.Nov.18 AD 12:08 PM");
         * System.out.println(""); DateUtility.parseDate("Wed, 18 Nov 2018 12:08:56 -0700");
         * DateUtility.parseDate("181118120856-0700");
         * DateUtility.parseDate("2018-11-18T12:08:56.235-0700");
         * DateUtility.parseDate("2018-11-18T12:08:56.235-07:00");
         * DateUtility.parseDate("2018-W27-3");
         */

    }
}
