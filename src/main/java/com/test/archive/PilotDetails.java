package com.test.archive;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PilotDetails {
    @ToString.Include
    private int pilotId;

    @ToString.Include
    private String lastName;

    @ToString.Include
    private String firstName;

}
