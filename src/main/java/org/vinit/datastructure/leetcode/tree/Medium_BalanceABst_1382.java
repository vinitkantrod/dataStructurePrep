package org.vinit.datastructure.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Medium_BalanceABst_1382 {

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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        return createBST(inorder, 0, inorder.size() - 1);
    }
    private void inOrderTraversal(TreeNode node, List<TreeNode> inorder) {
        if (node != null) {
            inOrderTraversal(node.left, inorder);
            inorder.add(node);
            inOrderTraversal(node.right, inorder);
        }
    }
    private TreeNode createBST(List<TreeNode> inorder, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftSubTree = createBST(inorder, start, mid - 1);
        TreeNode rightSubTree = createBST(inorder, mid + 1, end);
        TreeNode node = new TreeNode(inorder.get(mid).val, leftSubTree, rightSubTree);
        return node;
    }
}
