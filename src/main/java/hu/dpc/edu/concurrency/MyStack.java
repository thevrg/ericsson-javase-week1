package hu.dpc.edu.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vrg on 13/10/16.
 */
public class MyStack {

    private final Lock LOCK = new ReentrantLock();
    private final Condition NOT_EMPTY = LOCK.newCondition();
    private final Condition NOT_FULL = LOCK.newCondition();

    private final char[] chars = new char[10];
    private int index;

    public void push(char c) {
        final String tn = Thread.currentThread().getName() + ": ";
        System.out.println(tn + "push " + c );
        try {
            LOCK.lock();
            while (isFull()) {
                try {
                    System.out.println(tn + "waiting... ");
                    NOT_FULL.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isFull()) {
                    System.out.println(tn + "woke up, but why??... ");
                }
            }
            chars[index++] = c;
            System.out.println(tn + "pushed " + c);

            NOT_EMPTY.signal();
        } finally {
            LOCK.unlock();
        }
    }

    public char pop() {
        final String tn = Thread.currentThread().getName() + ": ";
        System.out.println(tn + "pop ");
        try {
            LOCK.lock();

            while(isEmtpy()) {
                try {
                    System.out.println(tn + "waiting... ");
                    NOT_EMPTY.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isEmtpy()) {
                    System.out.println(tn + "woke up, but why??... ");
                }
            }
            NOT_FULL.signal();

            final char popped = chars[--index];

            System.out.println(tn + "popped " + popped);

            return popped;
        } finally {
            LOCK.unlock();
        }
    }

    private boolean isFull() {
        return index >= chars.length - 1;
    }


    private boolean isEmtpy() {
        return index == 0;
    }
}
