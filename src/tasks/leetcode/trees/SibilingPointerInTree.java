package tasks.leetcode.trees;

public class SibilingPointerInTree {


    public void connectSiblings(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        // Важливо спочатку встановити покажчики для правого піддерева
        connectSiblings(root.right);
        connectSiblings(root.left);
    }

    private TreeNode getNext(TreeNode node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SibilingPointerInTree tree = new SibilingPointerInTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        tree.connectSiblings(root);

        System.out.println(root.left.next.val);  // Виведе: 3
        System.out.println(root.left.left.next.val);  // Виведе: 5
        System.out.println(root.left.right.next.val);  // Виведе: 6
    }

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
        }
    }
}
