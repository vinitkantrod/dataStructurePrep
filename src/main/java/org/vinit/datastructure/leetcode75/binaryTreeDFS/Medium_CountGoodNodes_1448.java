package org.vinit.datastructure.leetcode75.binaryTreeDFS;

import java.util.ArrayList;
import java.util.List;

public class Medium_CountGoodNodes_1448 {

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
    List<Integer> goodNodes = new ArrayList<>();
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return goodNodes.size();
    }
    private void dfs(TreeNode node, int maxVal) {
        if (node == null) return;
        if (node.val >= maxVal) goodNodes.add(node.val);
        dfs(node.left, Math.max(node.val, maxVal));
        dfs(node.right, Math.max(node.val, maxVal));
    }
}
