package com.test.example;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * This is a DOTC utility class.
 *
 * @author bhojan
 */
/**
 * @author ckayakakula
 *
 */
public final class DOTCDateUtil {

    private DOTCDateUtil() {
    }

    public static final String DAY_START_TIME = " 00:00:00";

    public static final String DAY_END_TIME = " 23:59:59";

    private static SimpleDateFormat dateFormatter;

    private static final String ERR_DATE_CONVERION_MSG = "Error converting date ";

    private static final String ERR_DATE_CONVERT_CAL_MSG = "Exception occurred while converting date to xml gregorian calender";

    private static final String ERROR = "ERROR:  ";

    private static final String DAY_OF_MONTH_FORMAT = "%02d";

    public static double getDaysBetween(final Date startDate, final Date endDate) {
        double dateDiff = 0;
        if (null != startDate && null != endDate) {
            final double seconds = 1000.0;
            final long minutes = 60;
            final long days = 24;
            final long diff = endDate.getTime() - startDate.getTime();
            dateDiff = ((diff / seconds) / (minutes * minutes)) / days;
        }

        return dateDiff;
    }

    public static Date getStartOfTheDay(final Date date) throws Exception {
        Calendar cal;
        cal = Calendar.getInstance();
        if (null == date) {
            cal.setTime(new Date());
        } else {
            cal.setTime(date);
        }
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getEndOfTheDay(final Date date) throws Exception {
        Calendar cal;
        cal = Calendar.getInstance();
        if (null == date) {
            cal.setTime(new Date());
        } else {
            cal.setTime(date);
        }
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    /**
     * This method returns the current date
     *
     * @return currentDate.
     */
    public static Date getCurrentDateUtil() {
        // return DateTime.now().toDate();
        return new Date();
    }

    public static Date convertStringDateToDateWithoutTime(final String dateStr) throws Exception {
        try {
            final SimpleDateFormat sd = getDateFormat("yyyy-MM-dd");
            return null != dateStr ? sd.parse(dateStr) : sd.parse(new Date().toString());
        } catch (final Exception e) {

        }
        return null;
    }

    public static SimpleDateFormat getDateFormat(final String dateFormat) throws Exception {
        try {
            dateFormatter = new SimpleDateFormat(dateFormat);
        } catch (final Exception e) {
        }

        return dateFormatter;
    }

    public static LocalDateTime convertStringToLocalDateTime(final String dateString, final String datePattern) {
        if (!StringUtils.hasLength(dateString) || !StringUtils.hasLength(datePattern)) {
            return null;
        }
        final java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return LocalDateTime.parse(dateString, formatter);
    }

    public static LocalDate convertStringToLocalDate(final String dateString, final String datePattern) {
        if (!StringUtils.hasLength(dateString) || !StringUtils.hasLength(datePattern)) {
            return null;
        }
        final java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return LocalDate.parse(dateString, formatter);
    }
}
