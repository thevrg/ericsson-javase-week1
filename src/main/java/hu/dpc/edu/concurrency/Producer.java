package hu.dpc.edu.concurrency;

/**
 * Created by vrg on 14/10/16.
 */
public class Producer implements Runnable {
    private MyStack stack;

    public Producer(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            char c = (char)((Math.random() * ('Z'-'A')) + 'A');
            stack.push(c);
            try {
                Thread.sleep((long)(Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Finished");
    }
}
