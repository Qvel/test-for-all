package tasks.arrays;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        /*for (int num : nums) {
            System.out.print(num + " ");
        }*/
        reverse(nums,0, nums.length-1);

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        reverseMy(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * Обертає масив на k позицій вправо.
     * @param nums Масив, який потрібно обертати.
     * @param k Кількість позицій для обертання.
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;  // Якщо k більше за довжину масиву, ми беремо залишок від ділення.

        // Звертаємо весь масив.
        reverse(nums, 0, n - 1);
        // Звертаємо перші k елементів.
        reverse(nums, 0, k - 1);
        // Звертаємо решту масиву.
        reverse(nums, k, n - 1);
    }

    /**
     * Звертає частину масиву між двома індексами.
     * @param nums Масив для звертання.
     * @param start Початковий індекс.
     * @param end Кінцевий індекс.
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void reverseMy(int [] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
