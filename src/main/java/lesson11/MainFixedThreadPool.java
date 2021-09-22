package lesson11;

public class MainFixedThreadPool {
    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            fixedThreadPool.execute(task);
        }
        fixedThreadPool.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fixedThreadPool.execute(new Task(6));
    }
}
