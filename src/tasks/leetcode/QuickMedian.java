package tasks.leetcode;

import java.util.Arrays;

public class QuickMedian {

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 10, 8, 3};
        System.out.println(findMedian(arr));
    }

    public static double findMedian(int[] arr) {
        //за замовчуванням : Timsort, який є комбінацією MergeSort та InsertionSort.
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }


    public static int findMedianQuickSelect(int[] arr) {
        if (arr.length % 2 == 1) {
            return quickSelect(arr, arr.length / 2);
        } else {
            return (quickSelect(arr, arr.length / 2 - 1) + quickSelect(arr, arr.length / 2)) / 2;
        }
    }

    public static int quickSelect(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                break;
            }
        }
        return arr[k];
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
