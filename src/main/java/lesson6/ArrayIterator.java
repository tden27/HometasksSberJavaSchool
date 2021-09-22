package lesson6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    T[] array;
    private final int count;
    private int index = 0;

    @SafeVarargs
    public ArrayIterator(T...args){
        array = Arrays.copyOf(args, args.length);
        count = array.length;
    }

    @Override
    public boolean hasNext() {
        return index < count;
    }

    @Override
    public T next() {
        if (index < count) {
            return array[index++];
        } else {
            throw new NoSuchElementException("No such element.");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove item from array.");
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{3, 6, 5, 7, 4, 5};
        Double[] doubles = new Double[]{0.1, 0.2, 0.3};

        Iterator<Integer> integerIterator = new ArrayIterator<>(integers);

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        Iterator<Double> doubleIterator = new ArrayIterator<>(doubles);
        while (doubleIterator.hasNext()) {
            System.out.println(doubleIterator.next());
        }

    }
}
