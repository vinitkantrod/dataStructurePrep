package org.vinit.datastructure.leetcode.leetcode75.binaryTreeDFS;

public class Easy_MaximumDepthOfBinaryTree_104 {

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

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
