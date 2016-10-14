package hu.dpc.edu.concurrency;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vrg on 14/10/16.
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(100);
        final long newValue = counter.addAndGet(34);


        long l = 100;
        l+=34;

    }
}
