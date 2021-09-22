package lesson11;

class Task implements Runnable {
    private final int num;

    public Task(int n) {
        num = n;
    }

    @Override
    public void run() {
        System.out.println("Task " + num + " was completed by " + Thread.currentThread().getName());
    }
}
