package com.java_8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrenthapMapTest {

    static int NO_THREDS = 5;

    static int NO_INSERTIONS = 100;

    static final Map<String, Integer> map = new HashMap<>();

    public static void main(final String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(NO_THREDS);
        for (int i = 0; i < NO_THREDS; i++) {
            executorService.execute(insertMethod());
        }
        executorService.shutdown();
        if (!executorService.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("Map Size :: " + map.size());
    }

    private static Runnable insertMethod() {

        return () -> {
            for (int i = 0; i < NO_INSERTIONS; i++) {
                map.put(i + Thread.currentThread().getName(), i);
            }
        };
    }

}
