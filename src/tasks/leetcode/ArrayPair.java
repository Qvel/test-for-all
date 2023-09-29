package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ArrayPair {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7};
        int sum = 9;

        System.out.println(hasPairWithSumBruteForce(arr, sum)); // true
    }

    //O(n^2)
    public static boolean hasPairWithSumBruteForce(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    //O(n)
    public static boolean hasPairWithSumHashSet(int[] arr, int sum) {
        Set<Integer> seen = new HashSet<>();

        for (int value : arr) {
            if (seen.contains(sum - value)) {
                return true;
            }
            seen.add(value);
        }

        return false;
    }
}
