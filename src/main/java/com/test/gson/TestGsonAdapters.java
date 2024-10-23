package com.test.gson;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.test.gson.LocalDateTimeTypeAdapter.LocalDateTypeAdapter;
import com.test.gson.LocalDateTimeTypeAdapter.LocalDateTypeAdapter4MMM;

public class TestGsonAdapters {

    public static void main(final String[] args) {
        final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter4MMM())
            .create();
        final String userObj =
            // "{\"dateOfJoin\":\"Oct 14, 2020 12:00:00 AM\"}";
            "{\"dateOfJoin\":\"2020-10-14\"}";
        final Type mapType = new TypeToken<CustomeUser>() {
        }.getType();
        final CustomeUser customeUser = gson.fromJson(userObj, mapType);
        System.out.println(customeUser.getDateOfJoin());
    }

}
