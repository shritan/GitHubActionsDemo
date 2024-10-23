package com.test.objectmapper;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
// @JsonIgnoreProperties(value = { "intValue" })
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
public class MyObject {
    private String stringValue;

    private int intValue;

    private boolean booleanValue;
}
