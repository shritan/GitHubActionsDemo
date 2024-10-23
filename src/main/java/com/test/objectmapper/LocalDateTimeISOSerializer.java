package com.test.objectmapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeISOSerializer extends JsonSerializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Override
    public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider serializers)
            throws IOException, JsonProcessingException {

        final String timeString = value != null ? value.format(formatter)
                : DATETIME_FORMAT;
        gen.writeString(timeString);
    }
}
