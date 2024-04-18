package org.vinit.datastructure.leetcode75.binarySearchTree;

import org.vinit.datastructure.leetcode75.binaryTreeDFS.Medium_LowestCommonAncestorOfTree_236;

public class Easy_SearchInBST_700 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
