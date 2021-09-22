package lesson11;

import java.util.Arrays;

public class MainScalableThreadPool {
    public static void main(String[] args) {
        ScalableThreadPool scalableThreadPool = new ScalableThreadPool(2, 5);

        for (int i = 0; i < 4; i++) {
            Task task = new Task(i);
            scalableThreadPool.execute(task);
        }

        scalableThreadPool.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(scalableThreadPool.getThreads()));
        scalableThreadPool.execute(new Task(11));
    }
}

