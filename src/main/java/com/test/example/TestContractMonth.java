package com.test.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

public class TestContractMonth {

    public static void main(final String[] args) {
        final LocalDateTime fromDate = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        final String sb = new StringBuilder()
            .append(fromDate.getMonth()
                .plus(20).getDisplayName(TextStyle.SHORT_STANDALONE, Locale.US).toUpperCase(Locale.ENGLISH))
            .append(String.valueOf(fromDate.getYear())).toString();
        System.out.println("SB :" + sb);
    }

}
