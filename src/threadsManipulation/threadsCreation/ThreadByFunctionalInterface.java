package threadsManipulation.threadsCreation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadByFunctionalInterface {
    public static void main(String[] args) {
        Callable<String> task = () -> {
            return "Thread running using Callable (Functional Interface): " + Thread.currentThread().getName();
        };

        FutureTask<String> futureTask = new FutureTask<>(task);
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            System.out.println("Result: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}