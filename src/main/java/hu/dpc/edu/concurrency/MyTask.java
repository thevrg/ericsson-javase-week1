package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 13/10/16.
 */
public class MyTask implements Runnable {

    private int i;
    private final Object o = new Object();

    @Override
    public void run() {
        final String tn = Thread.currentThread().getName();
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                if (i < 50) {
                    System.out.println(tn + ":" + i++);
                } else {
                    break;
                }
            }
        }
    }
}
