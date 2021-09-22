package lesson11;

import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue<Runnable> queue;

    public FixedThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue<>();
        threads = new PoolWorker[nThreads];
    }

    @Override
    public void start() {
        for (int i = 0; i < nThreads; i++) {
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

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
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
