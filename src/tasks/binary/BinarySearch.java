package tasks.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.println(isValidBSTStack(root));
        System.out.println(isValidBSTQueue(root));
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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //dfs Depth First Search
    public static boolean isValidBSTStack(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Long> lowerLimits = new Stack<>();
        Stack<Long> upperLimits = new Stack<>();

        nodeStack.push(root);
        lowerLimits.push(Long.MIN_VALUE);
        upperLimits.push(Long.MAX_VALUE);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            long lower = lowerLimits.pop();
            long upper = upperLimits.pop();

            if (node.val <= lower || node.val >= upper) {
                return false;
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                lowerLimits.push((long) node.val);
                upperLimits.push(upper);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
                lowerLimits.push(lower);
                upperLimits.push((long) node.val);
            }
        }

        return true;
    }

    //bfs Breadth First Search
    public static boolean isValidBSTQueue(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Long> lowerLimits = new LinkedList<>();
        Queue<Long> upperLimits = new LinkedList<>();

        nodeQueue.offer(root);
        lowerLimits.offer(Long.MIN_VALUE);
        upperLimits.offer(Long.MAX_VALUE);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            long lower = lowerLimits.poll();
            long upper = upperLimits.poll();

            if (node.val <= lower || node.val >= upper) {
                return false;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                lowerLimits.offer(lower);
                upperLimits.offer((long) node.val);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                lowerLimits.offer((long) node.val);
                upperLimits.offer(upper);
            }
        }

        return true;
    }
}
