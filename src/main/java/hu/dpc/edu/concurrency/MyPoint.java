package hu.dpc.edu.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vrg on 13/10/16.
 */
public class MyPoint {

    private final static AtomicInteger counter = new AtomicInteger();

    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
        counter.incrementAndGet();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getCounter() {
        return counter.get();
    }
}
