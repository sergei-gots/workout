package org.workout.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndExecutorServiceSubmit {

    public static void workout() {
        try {
            futureExample();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void futureExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future <Integer> future = executorService.submit(() -> {
            Thread.sleep(10_000);
            return(420);
        });

        if(!future.isDone()) {
            System.out.println("Submitted task is still being executing");
        }

        int result = future.get();
        System.out.println("result = " + result);

        executorService.shutdown();

    }
}
