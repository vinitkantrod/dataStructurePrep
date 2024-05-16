package org.vinit.datastructure.leetcode.tree;

public class Easy_SumOfLeftLeaves_404 {

    public static class TreeNode {
         int val;
          TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        getSum(root, false);
        return sum;
    }
    private static void getSum(TreeNode node, Boolean isNodeLeft) {
        if (node == null) return;
        if (isNodeLeft && node.left == null && node.right == null) sum += node.val;
        getSum(node.left, true);
        getSum(node.right, false);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        System.out.println(sumOfLeftLeaves(t));
    }
}
