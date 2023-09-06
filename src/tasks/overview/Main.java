package tasks.overview;

public class Main {
    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return mid;  // елемент знайдений, повертаємо індекс
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;  // елемент не знайдений
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Знаходимо індекс опорного елемента
            int pivotIndex = partition(array, low, high);

            // Рекурсивно сортуємо елементи до опорного
            quickSort(array, low, pivotIndex - 1);

            // Рекурсивно сортуємо елементи після опорного
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        // Вибираємо опорний елемент
        int pivot = array[high];

        // Індекс для розміщення опорного елемента на правильному місці.
        // Початково він встановлений перед першим елементом підмасиву.
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // Якщо поточний елемент менший за опорний
            if (array[j] < pivot) {
                i++;
                // Міняємо місцями елементи
                swap(array, i, j);
            }
        }

        // Розміщуємо опорний елемент на правильному місці (після всіх елементів, менших за нього)
        swap(array, i + 1, high);
        // Повертаємо індекс опорного елемента у відсортованому підмасиві
        return i + 1;
    }

    // Допоміжна функція для обміну елементів місцями
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
