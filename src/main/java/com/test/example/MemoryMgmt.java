package com.test.example;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryMgmt {

    public static void main(final String[] args) {
        final int mb = 1024 * 1024;
        final MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        final long xmx = memoryBean.getHeapMemoryUsage().getMax() / mb;
        final long xms = memoryBean.getHeapMemoryUsage().getInit() / mb;
        System.out.println("Initial Memory (xms) : mb ," + xms);

        System.out.println("Max Memory (xmx) :mb," + xmx);

    }

}
