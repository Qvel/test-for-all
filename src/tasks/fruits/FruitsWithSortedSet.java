package tasks.fruits;

import java.util.*;

public class FruitsWithSortedSet {
    private final TreeMap<Integer, String> weightToFruit = new TreeMap<>();
    private final SortedSet<Integer> weights = new TreeSet<>();
    private final Random random = new Random();

    public void addFruit(String fruit, int weight) {
        if (weight <= 0) throw new IllegalArgumentException("Вага повинна бути додатною");
        weightToFruit.put(weight, fruit);
        weights.add(weight);
    }

    public String getRandomFruit() {
        int totalWeight = weights.last();
        int randomWeight = random.nextInt(totalWeight);
        int weight = weights.tailSet(randomWeight).first();
        return weightToFruit.get(weight);
    }

    public static void main(String[] args) {
        FruitsWithSortedSet weightedRandom = new FruitsWithSortedSet();

        weightedRandom.addFruit("banan", 5);
        weightedRandom.addFruit("apple", 7);
        weightedRandom.addFruit("kivi", 11);

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String fruit = weightedRandom.getRandomFruit();
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);
        }
        ;
        System.out.println("After 10,000 iterations:");
        int total = countMap.values().stream().mapToInt(i -> i).sum();
        for (String fruit : countMap.keySet()) {
            System.out.println(fruit + ": " + countMap.get(fruit)*100/total + "%");
        }
    }
}
