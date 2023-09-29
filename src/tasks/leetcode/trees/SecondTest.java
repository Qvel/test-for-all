package tasks.leetcode.trees;

public class SecondTest {
    public static void main(String[] args) {
    }
    private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean isValidBST(TreeNode node, long minValue, long maxValue){
       if(node == null) return true;
       //checking for value
       if(node.val <= minValue || node.val >= maxValue) {
           return false;
       }
       return isValidBST(node.left, minValue, node.val) && isValidBST(node.right, node.val, maxValue);
    }
    private static int getHeight(TreeNode treeNode){
        if(treeNode == null) return 0;

        return 1 + Math.max(getHeight(treeNode.left), getHeight(treeNode.right));
    }
    private static void printOnDept(TreeNode treeNode, int dept) {
        if (treeNode == null) return;
        if(dept == 1){
            System.out.println(treeNode.val);
        }
        printOnDept(treeNode.left, dept-1);
        printOnDept(treeNode.right, dept-1);
    }
    public void connectSiblings(SibilingPointerInTree.TreeNode root) {
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
    private SibilingPointerInTree.TreeNode getNext(SibilingPointerInTree.TreeNode node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }


    public int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }

    public int findMinBST(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE; // або поверніть специфічне значення або киньте виключення
        }

        while (root.left != null) {
            root = root.left;
        }
        return root.val;
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
