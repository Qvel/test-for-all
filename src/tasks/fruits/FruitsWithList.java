package tasks.fruits;

import java.util.*;

public class FruitsWithList {
    private List<String> fruits = new ArrayList<>();
    private Random rand = new Random();

    public void addFruit(String fruit, int weight) {
        for (int i = 0; i < weight; i++) {
            fruits.add(fruit);
        }
    }

    public String getRandomFruit() {
        return fruits.get(rand.nextInt(fruits.size()));
    }

    public static void main(String[] args) {
        FruitsWithList weightedRandom = new FruitsWithList();

        weightedRandom.addFruit("apple", 7);
        weightedRandom.addFruit("banan", 5);
        weightedRandom.addFruit("kivi", 11);

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String fruit = weightedRandom.getRandomFruit();
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);
        }

        System.out.println("After 10,000 iterations:");
        int total = countMap.values().stream().mapToInt(i -> i).sum();
        for (String fruit : countMap.keySet()) {
            System.out.println(fruit + ": " + countMap.get(fruit)*100/total + "%");
        }
    }
}
