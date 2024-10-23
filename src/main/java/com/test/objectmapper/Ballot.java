package com.test.objectmapper;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ballot implements java.io.Serializable {

    private static final long serialVersionUID = -975148046L;

    @JsonFormat(pattern = "MMM d, yyyy, hh:mm:ss a")
    private java.util.Date updatedDate;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    // @JsonFormat(pattern = "MMM d, yyyy, hh:mm:ss a") or
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime updatedDate1;

    private String name;
}
