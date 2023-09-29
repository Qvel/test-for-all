package tasks.leetcode;

public class SortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        // Починаємо з верхнього правого кута
        int i = 0, j = n - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;  // Переходимо вниз
            } else {
                j--;  // Переходимо вліво
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15},
                {4, 8, 12, 16, 20},
                {5, 10, 15, 20, 25}
        };
        int target = 9;

        System.out.println(searchMatrix(matrix, target));  // Це поверне true, оскільки 9 є в матриці
    }
}
