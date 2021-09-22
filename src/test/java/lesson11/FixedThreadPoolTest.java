package lesson11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FixedThreadPoolTest {
    public FixedThreadPool fixedThreadPool;

    @Before
    public void createFixedThreadPool() {
        fixedThreadPool = new FixedThreadPool(7);
        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            fixedThreadPool.execute(task);
        }
    }

    @Test
    public void getQueueSizeTest() {
        Assert.assertEquals(fixedThreadPool.getQueue().size(), 5);
        fixedThreadPool.getQueue().poll();
    }

    @Test
    public void getQueueSizeAfterPollTaskTest() {
        fixedThreadPool.getQueue().poll();
        Assert.assertEquals(fixedThreadPool.getQueue().size(), 4);
    }
}
