package com.test.example;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadDump {
    public static void main(final String[] args) {
        final ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
        for (final ThreadInfo threadInfo : threadMxBean.dumpAllThreads(true, true)) {
            System.out.println(threadInfo.toString());
        }
    }
}
