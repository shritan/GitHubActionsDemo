package com.test.objectmapper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.example.DOTCDateUtil;

public class EventObjectMapper {

    public static void main(final String[] args) throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        // final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        // df.setTimeZone(TimeZone.getTimeZone("UTC"));

        final String toParse = "20-12-2014 02:30:00";
        final Date date = DOTCDateUtil.convertStringDateToDateWithoutTime("2021-04-07");
        // final Date date = df.parse(toParse);
        final Event event = new Event("party", date);

        final ObjectMapper mapper = new ObjectMapper();
        final String result = mapper.writeValueAsString(event);
        // assertThat(result, containsString(toParse));
        System.out.println("result .. " + result);
        System.out.println("Date .." + date);
        System.out.println(result.contains("2021-04-07"));
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(sdf);
        System.out.println(objectMapper.writeValueAsString(date));

        // Parse the date string using the SimpleDateFormat object.
        // final Date date1 = sdf.parse("Wed Apr 07 00:00:00 CDT 2021");
        final Date date1 = sdf.parse(date.toString());

        // Convert the Date object to a LocalDate object.
        final LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Print the LocalDate object.
        System.out.println(localDate);

    }

}
