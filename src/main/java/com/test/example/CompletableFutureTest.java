/**
 *
 */
package com.test.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 */
public class CompletableFutureTest {

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        final CompletableFuture<Void> future = completableFuture
            .thenRun(() -> System.out.println("Computation finished."));
        future.get();

    }

}
