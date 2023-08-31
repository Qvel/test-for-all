package tasks.fruits;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
You are given as input a list of fruit, each with a positive integer weight.
You have access to a random number generator rand(k) that returns a random number in 0, …, k-1.
Write a function that returns a random fruit, where each fruit is returned with probability proportional to its weight.
For example, Apple is returned 40% more often than Banana because 7 is 40% larger than 5.
Example input: apple - 7 banana - 5 kiwi - 11
https://leetcode.com/problems/random-pick-with-weight/
 */

public class Fruits {

    private static TreeMap<Integer, String> map = new TreeMap<>();
    private static Random rand = new Random();
    private static int total = 0;

    public static void addFruit(String fruit, int weight) {
        if (weight <= 0) throw new IllegalArgumentException("Weight should be positive");
        total += weight;
        map.put(total, fruit);
    }

    public String getRandomFruit() {
        int value = rand.nextInt(total); // to get a number in 1..total range
        return map.higherEntry(value).getValue();
    }

    public static void generateRandomListOfFruits(List<Fruit> fruitList) {
        fruitList.stream().sorted(Comparator.comparingInt(Fruit::getWeight)).forEach(
                fruit -> addFruit(fruit.getFruitName(), fruit.getWeight())
        );
    }

    public static void main(String[] args) {
        //1-6 > apple, 7-11 > banana, 12-22> kivi
        Fruits weightedRandom = new Fruits();
        Fruit apple = new Fruit(7, "apple");
        Fruit banana = new Fruit(5, "banana");
        Fruit kiwi = new Fruit(11, "kiwi");

        generateRandomListOfFruits(Stream.of(banana,apple,kiwi).collect(Collectors.toList()));

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String fruit = weightedRandom.getRandomFruit();
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);
        }

        System.out.println(total);
        System.out.println(map.toString());
        System.out.println("After 10,000 iterations:");
        int total = countMap.values().stream().mapToInt(i -> i).sum();
        for (String fruit : countMap.keySet()) {
            System.out.println(fruit + ": " + countMap.get(fruit)*100/total + "%");
        }
    }

    private static class Fruit {

        public Fruit(int weight, String fruitName) {
            this.weight = weight;
            this.fruitName = fruitName;
        }

        private final int weight;
        private final String fruitName;

        public int getWeight() {
            return weight;
        }

        public String getFruitName() {
            return fruitName;
        }
    }
}
