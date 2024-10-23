package com.test.objectmapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateDeserializer extends JsonDeserializer<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm:ss a");

    private final DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDateTime deserialize(final JsonParser jp, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String str = jp.getText();
        final String[] strAry = str.split(",");
        if (strAry.length >= 2 && !strAry[2].contains("0")) {
            strAry[2] = " 0" + strAry[2].trim();
        }
        str = String.join(",", strAry);
        return LocalDateTime.parse(str, formatter);
    }
}
