package com.test.gson;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDateTime dateOfbirth;

    private LocalDate dateOfJoin;
}
