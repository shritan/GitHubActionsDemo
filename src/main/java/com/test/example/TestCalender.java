package com.test.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.LocalDateTime;

public class TestCalender {
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(final String[] args) throws ParseException, DatatypeConfigurationException {

        // printHrs();
        // printGregorianCalendar();
        final LocalDate currentdate = LocalDate.now();
        // System.out.println("currentdate " + currentdate.getMonth());
        final Date tomorrow = Date.from(Calendar.getInstance().toInstant().plus(1, ChronoUnit.DAYS));
        // System.out.println("tomorrow " + tomorrow);
        testCrewBase();
    }

    private static void testCrewBase() throws ParseException {
        final SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        // isoFormat.setTimeZone(TimeZone.getTimeZone(ZoneOffset.systemDefault()));
        isoFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        final Date date = isoFormat.parse("2021-05-23T09:01:02");
        final int gmtOffset = -300;
        final Date crewBaseTime = Date.from(date.toInstant().plus(gmtOffset, ChronoUnit.MINUTES));
        final Date crewBaseTimeJoda = new LocalDateTime(date).plusMinutes(gmtOffset).toDate();
        System.out.println("crewBaseTime with Instant :: " + crewBaseTime);
        System.out.println("crewBaseTime with Joda T  :: " + crewBaseTimeJoda);
        System.out.println(crewBaseTime.toString().equals(crewBaseTimeJoda.toString()));
        /*
         * if (isCrewBaseTimeWithinDST(stationTimeInfo, gmtDateTime)) { gmtOffset += 60; //
         * crewBaseTime = new DateTime(gmtDateTime).plusMinutes(gmtOffset).toDate(); crewBaseTime =
         * Date.from(gmtDateTime.toInstant().plus(gmtOffset, ChronoUnit.MINUTES)); }
         */
    }

    private static void printHrs() throws ParseException {
        final String start_date = "2020-06-09 06:10:50";
        final String end_date = "2020-06-10 06:10:50";
        final Date d1 = sdf.parse(start_date);
        final Date d2 = sdf.parse(end_date);
        final java.time.LocalDateTime startLocalDateTime =
            Instant.ofEpochMilli(d1.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        final java.time.LocalDateTime endLocalDateTime =
            Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();

        final long diffInNano = ChronoUnit.NANOS.between(startLocalDateTime, endLocalDateTime);
        final long diffInSeconds = ChronoUnit.SECONDS.between(startLocalDateTime, endLocalDateTime);
        final long diffInMilli = ChronoUnit.MILLIS.between(startLocalDateTime, endLocalDateTime);
        final long diffInMinutes = ChronoUnit.MINUTES.between(startLocalDateTime, endLocalDateTime);
        final long diffInHours = ChronoUnit.HOURS.between(startLocalDateTime, endLocalDateTime);
        final long diffInDays = ChronoUnit.DAYS.between(startLocalDateTime, endLocalDateTime);
        System.out.println("diffInHours  " + diffInHours);
        System.out.println("diffInSeconds :: " + diffInSeconds);
        System.out.println("diffInMinutes :: " + diffInMinutes);
        System.out.println("diffInDays ::" + diffInDays);
    }

    private static void printGregorianCalendar() throws DatatypeConfigurationException {
        // final String reqPattern = currentUTCTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd
        // HH:mm:ss:SSS"));
        // System.out.println("Required pattern: " + reqPattern);
        final GregorianCalendar calendar = GregorianCalendar.from(java.time.LocalDateTime.now().atZone(ZoneId.systemDefault()));
        final XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        System.out.println("But Showing As :" + xcal);
    }
}
