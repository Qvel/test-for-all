package tasks.binary;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sampleArray = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int searchFor = 7;

        int result = binarySearch(sampleArray, searchFor);

        if (result == -1) {
            System.out.println("no such element");
        } else {
            System.out.println("element was found with index " + result);
        }


        // Тестовий приклад
        TreeNode root = new TreeNode(2);
        TreeNode firstLeft = new TreeNode(1);
        TreeNode firstRight = new TreeNode(5);
        root.left = firstLeft;
        root.right = firstRight;

        TreeNode secondLeft = new TreeNode(4);
        TreeNode secondRight = new TreeNode(6);
        firstRight.left = secondLeft;
        firstRight.right = secondRight;

        System.out.println(isValidBST(root));  // має вивести true
    }

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

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        // перевірка чи вузол входить у допустимий діапазон
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // перевірка лівого піддерева і правого піддерева
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Функція для перевірки, чи є дерево збалансованим
    public boolean isBalanced(TreeNode root) {
        // Якщо дерево порожнє, воно автоматично збалансоване
        if (root == null) return true;

        // Обчислюємо висоти лівого та правого піддерев
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Якщо різниця в висоті між лівим та правим піддеревом більше 1, дерево незбалансоване
        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        // Рекурсивно перевіряємо збалансованість лівого та правого піддерев
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Допоміжна функція для обчислення висоти піддерева
    private int getHeight(TreeNode node) {
        // Якщо вузол порожній, висота рівна 0
        if (node == null) return 0;

        // Висота дерева це 1 (поточний вузол) плюс максимум від висот лівого та правого піддерев
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
