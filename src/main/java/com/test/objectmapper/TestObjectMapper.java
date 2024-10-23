package com.test.objectmapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestObjectMapper {

    public static void main(final String[] args) throws Exception {

        final String testcaseDate =
            "{\"dfpType\": \"24\",\"dfpstartDateTime\": \"2023-08-23T00:00\",\"dfpendDateTime\": \"2023-08-24T23:59\",\r\n"
                    + "\"nextReservedayAvbldate\": \"2023-08-28T23:59\"}";
        try {
            DfpConflictInfo dfpConflictInfo = getObjectMapper().readValue(testcaseDate,
                new TypeReference<DfpConflictInfo>() {
                });
            System.out.println(dfpConflictInfo.getDfpType());
            dfpConflictInfo = getObjectMapper().readValue(testcaseDate, DfpConflictInfo.class);
            System.out.println(dfpConflictInfo.getDfpendDateTime());
            // wirteObject();
            // wirteManualNotifiationObject();
            wirteRapBallots();
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static <T> DfpConflictInfo deserializeMyExchange(final String json) throws IOException {
        return getObjectMapper().readValue(json, new TypeReference<DfpConflictInfo>() {
        });
    }

    public static ObjectMapper getObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;

    }

    public static String wirteObject() throws JsonProcessingException {
        final ManualNotificationRequest manualNotificationRequest = new ManualNotificationRequest();
        manualNotificationRequest.setBase("DFW");
        manualNotificationRequest.setDivision("D");
        manualNotificationRequest.setEquipment("320");
        manualNotificationRequest.setPosition("CA");
        manualNotificationRequest.setProcessDate("03-06-2024");
        final String req = getObjectMapper().writeValueAsString(manualNotificationRequest);
        System.out.println(req);
        return null;
    }

    public static String wirteManualNotifiationObject() throws JsonProcessingException {
        final UpdateManualNotificationsRequest updateManualNotificationsRequest = new UpdateManualNotificationsRequest();
        final List<ManualNotifications> manualNotificationRequest = new ArrayList<>();
        final ManualNotifications manualNotifications = new ManualNotifications();
        manualNotifications.setRunResultsId(123456l);
        manualNotifications.setManualNotificationNotify(1);
        manualNotificationRequest.add(manualNotifications);
        updateManualNotificationsRequest.setManualNotifications(manualNotificationRequest);
        final String req = getObjectMapper().writeValueAsString(updateManualNotificationsRequest);
        System.out.println(req);
        return null;
    }

    public static String wirteRapBallots() throws JsonProcessingException {
        final RapBallotRequest rapBallotRequest = new RapBallotRequest();
        final List<RapBallotTimes> rapBallotTimesList = new ArrayList<>();

        final RapBallotDetails rapBallotDetails = new RapBallotDetails();
        rapBallotDetails.setActiveInd(1);
        rapBallotDetails.setBallotType("Daily");
        rapBallotDetails.setContractMonth("MAR2024");
        rapBallotDetails.setCreatedBy(239820);
        rapBallotDetails.setDailyRapDate(LocalDate.now());
        rapBallotDetails.setEarliestRapTime(LocalDate.now());
        rapBallotDetails.setStandingInd(1);
        rapBallotDetails.setEmployeeId(1234567);
        rapBallotDetails.setLatestRapTime(LocalDate.now());
        rapBallotDetails.setRapBallotTimes(rapBallotTimesList);

        final RapBallotTimes rapBallotTimes = new RapBallotTimes();

        rapBallotTimes.setActiveInd(1);
        rapBallotTimes.setRapDuration(20);
        rapBallotTimes.setRapHours(1);
        rapBallotTimes.setRapMinutes(30);
        rapBallotTimes.setSortOrder(1);

        rapBallotTimesList.add(rapBallotTimes);
        rapBallotRequest.setRapBallotDetails(rapBallotDetails);
        final String req = getObjectMapper().writeValueAsString(rapBallotRequest);
        System.out.println("rapBallotDetails Request " + req);
        return null;
    }
}
