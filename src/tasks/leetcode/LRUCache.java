package tasks.leetcode;

import java.util.HashMap;

/*
Least Recently Used
для доступу до даних за О(1)

задачка була - LRU cache, тобто тобі треба реалізувати кеш, який має капасіті, наприклад 2

коли додаєш

а А
б Б
с С

то в кеші буде

б Б
с С

бо розмір кешу 2, і видаляється той, який юзався найдавніше
 */
public class LRUCache {

    private HashMap<String, Node> map; // Словник для зберігання ключ-вузол пари
    private int capacity; // Максимальний розмір кешу
    //представляє найстаріший (найдавніше використаний) елемент у кеші.
    private Node head; // Початковий вузол у двонаправленому списку
    // представляє найновіший (недавно доданий або використаний) елемент у кеші.
    private Node tail; // Кінцевий вузол у двонаправленому списку

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public String get(String key) {
        if(!map.containsKey(key)){
            return null;
        }
        Node node = map.get(key);
        remove(node); // Видалити вузол з поточної позиції
        addAtEnd(node); // Додати вузол до кінця
        return node.value;
    }

    public void put (String key, String value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value;
            addAtEnd(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.key); // Видалення найстарішого елемента
                remove(head);
            }
            Node newNode = new Node(key, value);
            addAtEnd(newNode);
            map.put(key, newNode);
        }
    }


    /*
    1. Метод remove(Node node):
    Цей метод призначений для видалення вказаного вузла з двонаправленого зв'язного списку.

    Якщо у вузла є попередній вузол (node.prev != null):

    З'єднуємо попередній вузол і наступний вузол відносно поточного вузла. Це ефективно "пропускає" поточний вузол в списку.
    Якщо вузол не має попереднього вузла (node.prev == null):

    Це означає, що поточний вузол є головою (head). Тому ми встановлюємо наступний вузол як нову голову.
    Якщо у вузла є наступний вузол (node.next != null):

    З'єднуємо наступний вузол і попередній вузол відносно поточного вузла.
    Якщо вузол не має наступного вузла (node.next == null):

    Це означає, що поточний вузол є хвостом (tail). Тому ми встановлюємо попередній вузол як новий хвіст.
     */
    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    /*
    Уявімо, що ми маємо список A <-> B <-> C і ми хочемо видалити B та додати D в кінець.

    Після виклику remove(B): список стає A <-> C
    Після виклику addAtEnd(D): список стає A <-> C <-> D
     */

    /*
    Цей метод призначений для додавання вузла в кінець двонаправленого зв'язного списку (до хвоста).

    Якщо хвіст існує (tail != null):

    Ми робимо поточний вузол наступним для хвоста. Це розширює список, додаючи новий вузол в кінець.
    Незалежно від того, чи існує хвіст, ми:

    Встановлюємо попередній вузол поточного вузла як хвіст.
    Вказуємо, що для поточного вузла немає наступного вузла (node.next = null), тому що він тепер стає новим хвостом.
    Встановлюємо поточний вузол як новий хвіст.
    Якщо голова не існує (head == null):

    Це означає, що список був порожнім. Тому ми встановлюємо поточний вузол як нову голову.
     */
    private void addAtEnd(Node node){
        if(tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        node.next = null;
        tail = node;
        if(head == null) {
            head = node;
        }
    }

    // Внутрішній клас для вузла
    private static class Node {
        String key;
        String value;

        Node prev; // Попередній вузол
        Node next; // Наступний вузол

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
