package org.vinit.datastructure.leetcode75.binaryTreeDFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Easy_LeafSimiliarTree_872 {

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
    List<Integer> leaf1 = new ArrayList<>(), leaf2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }
    private void dfs(TreeNode node, List<Integer> sb) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            sb.add(node.val);
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
    }
}
