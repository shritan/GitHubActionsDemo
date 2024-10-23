package com.test.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserObj {

    private Integer empId;

    private Double salary;

    private boolean prime;

    private int num;

    public static void validate() {
        final String str = "";
        System.out.println(str.trim().charAt(2));
    }
}
