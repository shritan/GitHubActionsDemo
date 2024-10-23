package com.test.gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private int id;

    private String name;

    /*
     * @Override public int compareTo(final Employee o) { return this.id - o.id; }
     */
}
