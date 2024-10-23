package com.test.example;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CrewMemberKeyDTO implements Serializable {

    private static final long serialVersionUID = 5531590384769443972L;

    @JsonProperty(required = true)
    @JsonPropertyDescription("Specifies airline code for which airport info is requested for (Ex: AA, MQ)")
    private AirlineCode airlineCode;

    private int employeeNumber;
}
