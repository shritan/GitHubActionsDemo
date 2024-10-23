package com.test.comparator;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Invoice {
    private int id;

    private double amount;

    private String number;

    private LocalDate createdOn;

    private String updateDate;
}
