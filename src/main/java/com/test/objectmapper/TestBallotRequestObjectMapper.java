package com.test.objectmapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.test.gson.BallotRequestJSONData;

public class TestBallotRequestObjectMapper {

    public static void main(final String[] args) throws JsonMappingException, JsonProcessingException {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        final LocalDate date = LocalDate.parse("20140218", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);
        formatter = DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm:ss a");
        final LocalDate date1 = LocalDate.parse("Oct 14, 2020, 12:00:00 AM", formatter);
        System.out.println(date1);

        final BallotRequestJSONData ballotRequestJSONData = buildBallotJSONData();
        System.out.println("Start Date " + ballotRequestJSONData.getStartDate());

    }

    private static BallotRequestJSONData buildBallotJSONData() throws JsonProcessingException {

        final String auditData = "{\"ballotRequestId\":12919,\"ballotType\":\"PDOTC\",\"requestStatus\":\"ACTIVE\",\"standingInd\":0,"
                + "\"startDate\":\"Oct 14, 2020, 12:00:00 AM\",\"endDate\":\"Oct 14, 2020, 12:00:00 AM\","
                + "\"requestDetails\":\"{\\\"sequences\\\":[{\\\"airlineCode\\\":\\\"AA\\\",\\\"contractMonth\\\":\\\"OCT2020\\\","
                + "\\\"premiumRequest\\\":false,\\\"sequenceStartDateTime\\\":\\\"2020-10-14 06:25:00\\\",\\\"sequenceEndDateTime\\\":\\\"2020-10-14 16:11:00\\\","
                + "\\\"layoverStations\\\":\\\"\\\",\\\"division\\\":\\\"I\\\",\\\"durationInDays\\\":1,\\\"employeeId\\\":0,\\\"firstLegDepartureAirport\\\":\\\"CLT\\\","
                + "\\\"lastLegArrivalAirport\\\":\\\"CLT\\\",\\\"legsPerDutyPeriod\\\":\\\"3\\\",\\\"quals\\\":\\\"\\\",\\\"timeAwayFromBase\\\":\\\"586\\\",\\\"totalCredit\\\":\\\"315\\\","
                + "\\\"firstLegDepartureDateTime\\\":\\\"2020-10-14 07:25:00\\\",\\\"lastLegArrivalDateTime\\\":\\\"2020-10-14 15:41:00\\\",\\\"conflict\\\":false,\\\"greaterWithConflict\\\":false,"
                + "\\\"base\\\":\\\"CLT\\\",\\\"FirstLegArrivalAirport\\\":\\\"MIA\\\",\\\"FirstLegDeadHead\\\":false,\\\"SANReserveOnly\\\":false}]}\",\"requestOrder\":0,\"activeInd\":1,\"updatedBy\":686340,"
                + "\"updatedDate\":\"Oct 14, 2020, 12:00:00 AM\",\"sequenceNumber\":4102,\"position\":\"CA\",\"originationDate\":\"Oct 14, 2020, 12:00:00 AM\",\"premiumRequest\":false,\"conflictIndicator\":false,"
                + "\"greaterConflictIndicator\":false}";
        return getObjectMapper().readValue(auditData, BallotRequestJSONData.class);
    }

    /*
     * public static <T> BallotRequestJSONData deserialize(final String json) throws IOException {
     * return getObjectMapper().readValue(json, new TypeReference<BallotRequestJSONData>() { }); }
     */
    public static ObjectMapper getObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        /*
         * objectMapper.setSerializationInclusion(Include.NON_NULL);
         * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         */
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return objectMapper;

    }
}
