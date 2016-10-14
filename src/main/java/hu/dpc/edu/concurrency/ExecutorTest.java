package hu.dpc.edu.concurrency;

import java.util.concurrent.*;

/**
 * Created by vrg on 14/10/16.
 */
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyStack stack = new MyStack();
        Producer producer = new Producer(stack);
        final Consumer consumer = new Consumer(stack);

        MyCallable c1 = new MyCallable(1000, "C1");
        MyCallable c2 = new MyCallable(1300, "C2");
        MyCallable c3 = new MyCallable(500, "C3");
        MyCallable c4 = new MyCallable(300, "throw C4");

        final Future<String> c1Future = executorService.submit(c1);
        final Future<String> c2Future = executorService.submit(c2);
        final Future<String> c3Future = executorService.submit(c3);
        final Future<String> c4Future = executorService.submit(c4);
        executorService.shutdown();
        System.out.println("shutdown...");

        System.out.println("submitted all callables");

        try {
            final String response = c4Future.get();
        } catch (ExecutionException ex) {
            Throwable originalEx = ex.getCause();
            System.out.println("c4 response is an exepection: " + originalEx);
        }

        final String c1Result = c1Future.get();

        System.out.println("c1Result: " + c1Result);

        c2Future.cancel(true);
        System.out.println("c2Future.isCancelled(): " + c2Future.isCancelled());
        c2Future.get();

        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("terminated...");

    }
}
