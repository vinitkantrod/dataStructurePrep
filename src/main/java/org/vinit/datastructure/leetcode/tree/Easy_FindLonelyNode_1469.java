package org.vinit.datastructure.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Easy_FindLonelyNode_1469 {

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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right != null) {
            result.add(node.right.val);
            dfs(node.right, result);
        } else if (node.left != null && node.right == null) {
            result.add(node.left.val);
            dfs(node.left, result);
        } else {
            dfs(node.left, result);
            dfs(node.right, result);
        }
    }
}
