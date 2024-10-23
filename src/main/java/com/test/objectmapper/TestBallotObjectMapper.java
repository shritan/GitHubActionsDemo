package com.test.objectmapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestBallotObjectMapper {

    public static void main(final String[] args) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_EMPTY);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        final String testcaseDate =
            // "{\"updatedDate1\": \"Sep 20, 2023, 3:23:41 PM\"}";
            "{\"updatedDate1\": \"Sep 20, 2023, 03:23:41 PM\"}";
        try {
            final Ballot ballot = objectMapper.readValue(testcaseDate,
                new TypeReference<Ballot>() {
                });
            System.out.println(ballot);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
