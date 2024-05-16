package org.vinit.datastructure.leetcode.leetcode75.binaryTreeDFS;

public class Medium_ZigzagTraversal_1372 {

    public class TreeNode {
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
    int maxPathSum = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxPathSum;
    }
    private void dfs(TreeNode node, Boolean goLeft, int depth) {
        if (node == null) return;
        maxPathSum = Math.max(maxPathSum, depth);
        if (goLeft) {
            dfs(node.left, false, depth + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, depth + 1);
        }
    }
}
