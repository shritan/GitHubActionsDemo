package com.test.objectmapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestGenericMapper {

    public static void main(final String[] args) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        final MyObject dtoObject = new MyObject();

        try {
            final String dtoAsString = objectMapper.writeValueAsString(dtoObject);
            System.out.println("Object as String Format " + dtoAsString);

            final String object = "{\"stringValue\":null,\"booleanValue\":false}";
            final MyObject myDto = objectMapper.readValue(object, MyObject.class);
            System.out.println("String as Object " + myDto);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
