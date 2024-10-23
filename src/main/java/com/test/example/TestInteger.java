package com.test.example;

public class TestInteger {

    public static void main(final String[] args) {
        final Integer integer = 20;
        final Integer integer2 = 21;
        /*
         * if (integer.equals(integer2)) { System.out.println("Both Are Same"); }
         */
        if (integer == integer2) {
            System.out.println("Both Are Same in == Case");
        }
        final Integer a = 10;
        final Integer b = 100;
        final Integer x = 200;
        final Integer y = 200;

        // This might be true because of Integer caching
        if (a == b) {
            System.out.println("a == b");
        } else {
            System.out.println("a != b");
        }

        // This will likely be false because the objects are different
        if (x == y) {
            System.out.println("x == y");
        } else {
            System.out.println("x != y");
        }

        // Correct way using equals method
        if (x.equals(y)) {
            System.out.println("x equals y");
        } else {
            System.out.println("x does not equal y");
        }

    }
}
