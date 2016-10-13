package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 13/10/16.
 */
public class MyStack {
    private final char[] chars = new char[10];
    private int index;

    public synchronized void push(char c) {
            chars[index++] = c;
    }

    public synchronized char pop() {
            return chars[--index];
    }

    public synchronized static char[] valami() {
        return new char[] {'c'};
    }
}
