package tasks.leetcode;
/*

 */
public class ArrayRotate {
    public static void main(String[] args) {
        int[] arr = {4, 6, 22, 8, 13, 5, 9};
        int k = 3;

        rotateArray(arr, k);
        //should be [13, 5, 9, 4, 6, 22, 8]
        //rotateArrayDefault(arr,k);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }



    public static void rotateArray(int[] arr, int k) {
        if (arr == null || k < 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        int len = arr.length;
        k = k % len; // Щоб підтримувати обертання для великих значень k
        // Інвертуємо частини масиву
        /*
        Ліву частину
        Оригінал: [4, 6, 22, 8, 13, 5, 9]
        Інвертування: [8, 22, 6, 4, 13, 5, 9]
        Діапазон: [0, 7 - 3 - 1] = [0, 3]
        k=3
         */
        reverseArray(arr, 0, len - k - 1);
        /*
        праву частину
        Оригінал після першого інвертування: [8, 22, 6, 4, 13, 5, 9]
        Інвертування: [8, 22, 6, 4, 9, 5, 13]
        Діапазон: [7 - 3, 7 - 1] = [4, 6]
        k=3
         */
        reverseArray(arr, len - k, len - 1);
        /*
        увесь масив
        Оригінал після другого інвертування: [8, 22, 6, 4, 9, 5, 13]
        Інвертування: [13, 5, 9, 4, 6, 22, 8]
        Діапазон: [0, 7 - 1] = [0, 6]
        k=3
         */
        reverseArray(arr, 0, len - 1);
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //Цей метод працює зі складністю O(n*k), де n - розмір масиву, а k - кількість обертів
    public static void rotateArrayDefault(int[] arr, int k) {
        if (arr == null || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        int n = arr.length;
        k = k % n;  // У випадку, якщо k більше за довжину масиву
        //{4, 6, 22, 8, 13, 5, 9}
        while (k-- > 0) {
            int temp = arr[n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        }
    }
}
