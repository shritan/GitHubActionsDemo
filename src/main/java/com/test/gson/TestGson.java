package com.test.gson;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.gson.LocalDateTimeTypeAdapter.LocalDateTypeAdapter;

public class TestGson {

    public static void main(final String[] args) {
        // final User user = new User(1L, "lokesh", "gupta", LocalDate.of(1999, Month.JANUARY, 1));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(01, 00)));
        System.out.println(LocalDate.now());
        // final User user = new User(1L, "lokesh", "gupta", LocalDateTime.of(LocalDate.now(),
        // LocalTime.of(01, 00)));
        final User user = new User(1L, "lokesh", "gupta", LocalDateTime.now(), LocalDate.now());

        final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();

        // {"id":1,"firstName":"lokesh","lastName":"gupta","dateOfbirth":{"date":{"year":2023,"month":7,"day":27},"time":{"hour":10,"minute":2,"second":2,"nano":657738400}},"dateOfJoin":{"year":2023,"month":7,"day":27}}
        final String userObj =
            "{\"id\":1,\"firstName\":\"lokesh\",\"lastName\":\"gupta\",\"dateOfbirth\":{\"date\":{\"year\":2023,\"month\":7,\"day\":27},\"time\":{\"hour\":10,\"minute\":2,\"second\":2,\"nano\":657738400}},\"dateOfJoin\":{\"year\":2023,\"month\":7,\"day\":27}}";

        // final Gson gson = new Gson();
        final String jsonString = gson.toJson(user);
        System.out.println(jsonString);
        // user = new Gson().fromJson(jsonString, User.class);
        System.out.println(user);
        // user = gson.(jsonString, User.class);
    }
    // 2023-10-29T01:00
}
