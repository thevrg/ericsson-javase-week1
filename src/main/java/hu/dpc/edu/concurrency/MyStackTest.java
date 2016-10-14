package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 14/10/16.
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Producer producer = new Producer(stack);
        final Consumer consumer = new Consumer(stack);

        Thread p1 = new Thread(producer, "P1");
        Thread p2 = new Thread(producer, "P2");
        Thread p3 = new Thread(producer, "P3");
        Thread c1 = new Thread(consumer, "C1");
        Thread c2 = new Thread(consumer, "C2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }

}
