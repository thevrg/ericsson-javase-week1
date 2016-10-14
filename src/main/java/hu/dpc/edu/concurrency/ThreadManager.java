package hu.dpc.edu.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vrg on 14/10/16.
 */
public class ThreadManager {

    private volatile boolean timeToShutDown;
    private List<Thread>threadList = Collections.synchronizedList(new ArrayList<>());

    public void shutdown() {
        this.timeToShutDown = true;

        synchronized (threadList) {
            for (Thread thread : threadList) {
                thread.interrupt();
            }
        }
    }

    public boolean isTimeToShutDown() {
        return timeToShutDown;
    }

    public void registerThread(Thread thread) {
        threadList.add(thread);
    }

    public void degisterThread(Thread thread) {
        threadList.remove(thread);
    }

}
