package hu.dpc.edu.concurrency;

import java.util.concurrent.Callable;

/**
 * Created by vrg on 14/10/16.
 */
public class MyCallable implements Callable<String> {

    private static final ThreadLocal<String>lastNameInThread = new ThreadLocal<>();

    private long waitFor;
    private String name;

    public MyCallable(long waitFor, String name) {
        this.waitFor = waitFor;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        final String tn = Thread.currentThread().getName() + ": ";
        System.out.println(tn + "Last name in this thread was: " + lastNameInThread.get());
        lastNameInThread.set(name);
        try {
            System.out.println(tn + "Starting job " + this.name);
            Thread.sleep(waitFor);
            System.out.println(tn + name + "completed");
            if (name.startsWith("throw")) {
                throw new RuntimeException("Hello world, " + name);
            }
            return "Response from task " + name;
        } catch (InterruptedException ex) {
            System.out.println(tn + "interrupted...");
            throw ex;
        }
    }
}
