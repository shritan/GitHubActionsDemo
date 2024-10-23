package com.java_8;

import java.util.Optional;

public class TestOptional {

    public static void main(final String[] args) {
        final String name = null;
        final Optional<String> nameOptional = Optional.ofNullable(name);
        nameOptional.ifPresent(t -> System.out.println(t));
    }

}
