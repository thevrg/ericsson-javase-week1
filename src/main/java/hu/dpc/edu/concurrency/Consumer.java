package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 14/10/16.
 */
public class Consumer implements Runnable {
    private MyStack stack;

    public Consumer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            char c = stack.pop();
            try {
                Thread.sleep((long)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Finished");
    }
}
