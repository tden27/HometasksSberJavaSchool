package lesson3.collectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils{
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        return source.subList(0, size-1);
    }

    public static <T> void add(List<T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<T> c1, List<? extends T> c2) {
        for (T t : c2){
            if (c1.contains(t)) return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<T> result = new ArrayList<>();
        for (T t : list){
            if (t.compareTo(min) >= 0 & t.compareTo(max) <= 0) result.add(t);
        }
        return result;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        for (T t : list){
            if (comparator.compare(t, min) >= 0 & comparator.compare(t, max) <= 0) result.add(t);
        }
        return result;
    }
}
