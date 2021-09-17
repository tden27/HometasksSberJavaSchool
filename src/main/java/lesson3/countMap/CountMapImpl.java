package lesson3.countMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<K> implements CountMap<K>{
    Map<K, java.lang.Integer> countHashMap = new HashMap<>();

    // добавляет элемент в этот контейнер.
    @Override
    public void add(Object o) {
        if (countHashMap.containsKey((K)o)) countHashMap.replace((K) o, countHashMap.get((K)o) + 1);
        else countHashMap.put((K) o, 1);
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(Object o) {
        return countHashMap.get(o);
    }

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(Object o) {
        return countHashMap.remove(o);
    }

    //количество разных элементов
    @Override
    public int size() {
        return countHashMap.size();
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей, суммировать значения
    @Override
    public void addAll(CountMap<? extends K> source) {
        for (Map.Entry<? extends K, Integer> entry : source.toMap().entrySet()){
            if (countHashMap.containsKey(entry.getKey())) countHashMap.replace(entry.getKey(), countHashMap.get(entry.getKey()) + entry.getValue());
            else countHashMap.put(entry.getKey(), entry.getValue());
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public Map<K, Integer> toMap() {
        return new HashMap<>(countHashMap);
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map<K, Integer> destination) {
        destination = new HashMap<>(countHashMap);
    }
}
