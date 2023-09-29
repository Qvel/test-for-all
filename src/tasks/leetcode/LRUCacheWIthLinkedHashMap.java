package tasks.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Ми використовуємо LinkedHashMap з активованим режимом доступу (третій параметр конструктора встановлено в true).
 Це означає, що порядок елементів у мапі буде визначатися порядком, в якому до них було звернення, а не порядком додавання.

Ми перевизначаємо метод removeEldestEntry(), щоб він повертав true,
коли розмір кешу перевищує встановлену місткість. Це автоматично призведе до видалення найстарішого запису з кешу, коли новий запис буде додано до переповненого кешу.

Такий підхід простий та ефективний завдяки використанню вбудованої в Java структури даних.
 */
public class LRUCacheWIthLinkedHashMap<K,V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCacheWIthLinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCacheWIthLinkedHashMap.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCacheWIthLinkedHashMap<String, String> cache = new LRUCacheWIthLinkedHashMap<>(2);
        cache.put("a", "A");
        cache.put("b", "B");
        System.out.println(cache.get("a"));  // Виведе: A
        cache.put("c", "C");
        System.out.println(cache.get("b"));  // Виведе: null, тому що "b" було видалено з кешу
    }
}
