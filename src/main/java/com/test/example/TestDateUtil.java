package com.test.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateUtil {
    static String format = "yyyy-MM-dd HH:mm:ss";

    public static void main(final String[] args) throws ParseException {

        /*
         * final String startDate = "2023-09-01"; final LocalDateTime seqStartDate =
         * DOTCDateUtil.convertStringToLocalDateTime(startDate + " 00:00:00", format);
         * System.out.println("Local Date :: " +
         * seqStartDate.plusDays(0).plusHours(23).plusMinutes(59).plusSeconds(59)); final String
         * trStartDate = "2023-09-01 07:00:00"; final LocalDateTime trEndDate =
         * DOTCDateUtil.convertStringToLocalDateTime(trStartDate, format);
         * System.out.println(trEndDate);
         */

        final String date = "2024-02-01 00:00:00.000";
        final String sDate6 = "31-Dec-1998 23:37:50";
        final SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        final Date date6 = formatter6.parse(sDate6);

        final SimpleDateFormat formatter7 = new SimpleDateFormat(format);
        final Date date7 = formatter7.parse(date);
        System.out.println(date7);
    }

}
