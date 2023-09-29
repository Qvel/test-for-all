package tasks.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem: Given a binary (or, optionally, any other kind of) tree, print out all of the nodes at a given depth d.
 */
public class TreeDepth {
    public static void main(String[] args) {
        // Тестовий приклад
        /*
             2
           1   5
             4   6
         */
        TreeNode root = new TreeNode(2);
        TreeNode firstLeft = new TreeNode(1);
        TreeNode firstRight = new TreeNode(5);
        root.left = firstLeft;
        root.right = firstRight;

        TreeNode secondLeft = new TreeNode(4);
        TreeNode secondRight = new TreeNode(6);
        firstRight.left = secondLeft;
        firstRight.right = secondRight;

        //dept 2
        printNodesAtDepth(root, 2);
    }

    private static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static void printNodesAtDepth(TreeNode treeNode, int d) {
        if (treeNode == null) return;

        if (d == 1) {
            System.out.println(treeNode.val);
        } else {
            printNodesAtDepth(treeNode.left, d-1);
            printNodesAtDepth(treeNode.right, d-1);
        }
    }

    /* to do :
    Ітеративний підхід з використанням черги: в цьому підході ми
    використовуємо структуру даних "черга" для обходу дерева по рівнях.
     Починаючи з кореня, ми додаємо його до черги. Потім, поки черга не пуста,
     ми видаляємо з неї вузол і додаємо його дітей до черги. Цей процес продовжується, поки ми не дійдемо до потрібної глибини.
      Коли ми досягаємо потрібної глибини, всі вузли в черзі є вузлами цього рівня, і їх можна вивести.
     */
    private static void printNodesAtDepthQueue(TreeNode root, int d) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int currentDepth = 1; // Починаємо з кореня

        while (!queue.isEmpty() && currentDepth < d) {
            int size = queue.size(); // Кількість вузлів на поточному рівні

            // Обробляємо всі вузли на поточному рівні
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            currentDepth++;
        }

        // Після циклу, якщо currentDepth == d, всі вузли в черзі належать до рівня d
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().val);
        }
    }

    /*
    to do:
    Ітеративний підхід з використанням стеку: це трохи менш очевидний підхід, але він також може бути корисним,
     особливо якщо вам потрібно обходити дерево у глибину замість обходу по рівнях.
     */



    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
