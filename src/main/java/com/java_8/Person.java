package com.java_8;

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
public class Person {

    private int id;

    private String firstName;

    private String lastName;

    /*
     * @Override public int hashCode() { return Objects.hash(firstName, age); // Generate hash code
     * based on fields }
     *
     * @Override public boolean equals(final Object obj) { if (this == obj) { return true; } if (obj
     * == null || getClass() != obj.getClass()) { return false; } final Person person = (Person)
     * obj; return age == person.age && Objects.equals(firstName, person.firstName); // &&
     * Objects.equals(lastName, person.lastName); }
     */
}
