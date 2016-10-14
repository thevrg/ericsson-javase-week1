package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 13/10/16.
 */
public class MyTask implements Runnable {

    private int i;
    private final Object o = new Object();
    private ThreadManager threadManager;

    public MyTask(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }

    @Override
    public void run() {
        final String tn = Thread.currentThread().getName();
        while (true) {
            if (threadManager.isTimeToShutDown()) {
                System.out.println(tn + ": shutting down...");
                return;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                if (threadManager.isTimeToShutDown()) {
                    System.out.println(tn + ": shutting down, because of an interrupt...");
                    return;
                }

            }
            synchronized (o) {

                if ( i >= 15 && tn.equals("T2")) {
                    throw new RuntimeException("T2 Halal...");
                }
                if (i < 50) {
                    System.out.println(tn + ":" + i++);
                } else {
                    break;
                }
            }
        }
    }
}
