package tasks.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCacheQueue<K, V>  {

    private final int capacity;
    private final Map<K, V> map;
    private final Queue<K> queue;

    public LRUCacheQueue(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) return null;

        // Оновлюємо порядок ключів
        queue.remove(key);
        queue.add(key);
        return map.get(key);
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            // Якщо ключ уже існує, видаляємо його з черги перед оновленням його позиції
            queue.remove(key);
        } else if (queue.size() == capacity) {
            // Якщо досягнута максимальна місткість, видаляємо найстаріший ключ
            K oldestKey = queue.poll(); //отримує та видаляє елемент з початку черги. Якщо черга порожня,
            map.remove(oldestKey);
        }

        map.put(key, value);
        queue.add(key);
    }

    public static void main(String[] args) {
        LRUCacheQueue<String, String> cache = new LRUCacheQueue<>(2);
        cache.put("a", "A");
        cache.put("b", "B");
        System.out.println(cache.get("a"));  // Виведе: A
        cache.put("c", "C");
        System.out.println(cache.get("b"));  // Виведе: null, тому що "b" було видалено з кешу
    }
}
