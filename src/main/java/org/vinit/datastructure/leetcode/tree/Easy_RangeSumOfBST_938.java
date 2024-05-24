package org.vinit.datastructure.leetcode.tree;

public class Easy_RangeSumOfBST_938 {

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

    int answer;
    public int rangeSumBST(TreeNode root, int low, int high) {
        answer = 0;
        traverse(root, low, high);
        return answer;
    }
    private void traverse(TreeNode node, int low, int high) {
        if (node == null) return;
        if (node.val >= low && node.val <= high) answer += node.val;
        if (node.val>= low) traverse(node.left, low, high);
        if (node.val <= high) traverse(node.right, low, high);
    }
}
