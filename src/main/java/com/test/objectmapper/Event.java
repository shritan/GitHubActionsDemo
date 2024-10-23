package com.test.objectmapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Event {
    public Event(final String string, final Date date) {
        this.name = string;
        this.eventDate.add(date);
    }

    public String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    List<Date> eventDate = new ArrayList<>();
}
