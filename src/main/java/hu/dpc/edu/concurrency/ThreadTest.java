package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 13/10/16.
 */
public class ThreadTest {
    public static void main(String[] args) {

        MyTask task = new MyTask();

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T2");

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main thread finished");
    }

}
