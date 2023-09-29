package tasks.leetcode.trees;

public class MorrisTraversal {
    public void inorderMorris(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " "); // Вивід значення вузла
                current = current.right; // Перехід до правого підвузла
            } else {
                // Знайти переддостанній вузол у лівому піддереві поточного вузла
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Якщо правий підвузол переддостаннього вузла є null,
                // створіть тимчасову підв'язку до поточного вузла
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                // Якщо правий підвузол переддостаннього вузла вже вказує на поточний вузол,
                // видаліть підв'язку і перейдіть до правого підвузла поточного вузла
                else {
                    predecessor.right = null;
                    System.out.print(current.val + " "); // Вивід значення вузла
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MorrisTraversal mt = new MorrisTraversal();
        mt.inorderMorris(root); // Вивід: 4 2 5 1 3
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
