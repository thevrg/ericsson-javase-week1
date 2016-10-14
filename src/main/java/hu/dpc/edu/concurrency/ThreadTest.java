package hu.dpc.edu.concurrency;

import java.util.Timer;

/**
 * Created by vrg on 13/10/16.
 */
public class ThreadTest {
    public static void main(String[] args) {

        final ThreadManager tm = new ThreadManager();

        MyTask task = new MyTask(tm);

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        tm.registerThread(t1);
        tm.registerThread(t2);
        tm.registerThread(t3);

        System.out.println("T1 is alive: " + t1.isAlive());

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
        t2.start();
        t3.start();

        System.out.println("T1 is alive: " + t1.isAlive());

        final Timer timer = new Timer();

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                tm.shutdown();
//                timer.cancel();
//            }
//        }, 3000L);

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("T1 is alive: " + t1.isAlive());

        System.out.println("Main thread finished");

    }

}
