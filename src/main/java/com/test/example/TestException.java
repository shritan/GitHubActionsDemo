package com.test.example;

import java.util.Collections;

import org.springframework.util.StringUtils;

public class TestException {

    public static void main(final String[] args) {
        try {
            /*
             * final String str = null; str.length();
             */
            UserObj.validate();

            StringUtils.isEmpty(args);
            Collections.emptyList();
        } catch (final Exception e) {
            // System.out.println(e.getLocalizedMessage());
            // System.out.println(e.getMessage());
            // System.out.println(e.getCause());
            // System.out.println(e.getClass());
            // System.out.println(e.getStackTrace());
            // System.out.println(e);
            // e.printStackTrace();
            final StackTraceElement[] stackTrace = e.getStackTrace();

            if (stackTrace.length >= 1) {
                final StackTraceElement trace = stackTrace[stackTrace.length - 1];
                final String traceInfo = trace.getClassName() + "."
                        + trace.getMethodName() + ":" + trace.getLineNumber()
                        + "(" + trace.getFileName() + ")";
                System.out.println(traceInfo);
            }

            for (final StackTraceElement trace : stackTrace) {
                final String traceInfo =
                    trace.getClassName() + "." + trace.getMethodName() + ":" + trace.getLineNumber() +
                            "(" + trace.getFileName() + ")";
                System.out.println(traceInfo);
            }

        }
    }

}
