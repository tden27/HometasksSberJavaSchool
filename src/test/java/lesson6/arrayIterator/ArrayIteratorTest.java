package lesson6.arrayIterator;

import org.junit.*;

public class ArrayIteratorTest {
    public ArrayIterator<Integer> integers;

    @Before
    public void createArrayIterator(){
        integers = new ArrayIterator<>(7,5,3,7,8);
    }

    @Test
    public void testHasNext() {
        for (int i = 0; i < integers.array.length-1; i++){
            integers.next();
            Assert.assertTrue(integers.hasNext());
        }
    }

    @Test
    public void testNext() {
        for (int i = 0; i < integers.array.length; i++){
            Assert.assertEquals(integers.array[i], integers.next());
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove(){
        integers.remove();
    }
}
