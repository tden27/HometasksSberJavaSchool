package lesson11;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableThreadPool implements ThreadPool {
    private final int minThreads;
    private final int maxThreads;
    private int nThreads;
    private PoolWorker[] threads;
    private final LinkedBlockingQueue<Runnable> queue;

    public ScalableThreadPool(int minThreads, int maxThreads) {
        this.minThreads = minThreads;
        this.maxThreads = maxThreads;
        queue = new LinkedBlockingQueue<>();
        nThreads = minThreads;
        threads = new PoolWorker[nThreads];
    }

    @Override
    public void start() {
        if (queue.size()>minThreads) {
            if (queue.size()<maxThreads) threads = new PoolWorker[queue.size()];
            else threads = new PoolWorker[maxThreads];
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    public LinkedBlockingQueue<Runnable> getQueue() {
        return queue;
    }

    public PoolWorker[] getThreads() {
        return threads;
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            threads = Arrays.copyOf(threads, minThreads);
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = queue.poll();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
}
