package com.test.gson;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.test.gson.LocalDateTimeTypeAdapter.LocalDateTypeAdapter4MMM;

public class TestBallotRequestJSONData {

    public static void main(final String[] args) {
        final String dateStr = "Oct 14, 2020, 12:00:00 AM";
        final LocalDate date = LocalDate.parse("20140218", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm:ss a");
        final LocalDate date1 = LocalDate.parse(dateStr, formatter);
        System.out.println(date1);

        final BallotRequestJSONData ballotRequestJSONData = buildBallotJSONData();
        System.out.println("Start Date " + ballotRequestJSONData.getStartDate());
    }

    private static BallotRequestJSONData buildBallotJSONData() {

        final String auditData = "{\"ballotRequestId\":12919,\"ballotType\":\"PDOTC\",\"requestStatus\":\"ACTIVE\",\"standingInd\":0,"
                + "\"startDate\":\"Oct 14, 2020 12:00:00 AM\",\"endDate\":\"Oct 14, 2020 12:00:00 AM\","
                + "\"requestDetails\":\"{\\\"sequences\\\":[{\\\"airlineCode\\\":\\\"AA\\\",\\\"contractMonth\\\":\\\"OCT2020\\\","
                + "\\\"premiumRequest\\\":false,\\\"sequenceStartDateTime\\\":\\\"2020-10-14 06:25:00\\\",\\\"sequenceEndDateTime\\\":\\\"2020-10-14 16:11:00\\\","
                + "\\\"layoverStations\\\":\\\"\\\",\\\"division\\\":\\\"I\\\",\\\"durationInDays\\\":1,\\\"employeeId\\\":0,\\\"firstLegDepartureAirport\\\":\\\"CLT\\\","
                + "\\\"lastLegArrivalAirport\\\":\\\"CLT\\\",\\\"legsPerDutyPeriod\\\":\\\"3\\\",\\\"quals\\\":\\\"\\\",\\\"timeAwayFromBase\\\":\\\"586\\\",\\\"totalCredit\\\":\\\"315\\\","
                + "\\\"firstLegDepartureDateTime\\\":\\\"2020-10-14 07:25:00\\\",\\\"lastLegArrivalDateTime\\\":\\\"2020-10-14 15:41:00\\\",\\\"conflict\\\":false,\\\"greaterWithConflict\\\":false,"
                + "\\\"base\\\":\\\"CLT\\\",\\\"FirstLegArrivalAirport\\\":\\\"MIA\\\",\\\"FirstLegDeadHead\\\":false,\\\"SANReserveOnly\\\":false}]}\",\"requestOrder\":0,\"activeInd\":1,\"updatedBy\":686340,"
                + "\"updatedDate\":\"Oct 14, 2020 12:00:00 AM\",\"sequenceNumber\":4102,\"position\":\"CA\",\"originationDate\":\"Oct 14, 2020 12:00:00 AM\",\"premiumRequest\":false,\"conflictIndicator\":false,"
                + "\"greaterConflictIndicator\":false}";
        Gson gson = null;
        final String reg = "^.*,.*$";
        final Matcher matcher = Pattern.compile(reg).matcher(auditData);
        if (matcher.find()) {
            gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                // .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter4MMM())
                .create();
        }
        final Type mapType = new TypeToken<BallotRequestJSONData>() {
        }.getType();
        return gson.fromJson(auditData, mapType);
    }
}
