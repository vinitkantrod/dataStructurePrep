package org.vinit.datastructure.leetcode.dp.decisionMaking;

import java.util.Arrays;

public class Medium_HouseRobberThree_337 {

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
    public static int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int[] res = robbing(root);
        return Math.max(res[0], res[1]);
    }
    public static int[] robbing(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        if (node.left == null && node.right == null) return new int[]{node.val, 0};
        int[] result = new int[2];
        int[] left = robbing(node.left);
        int[] right = robbing(node.right);
        // if rob this node, then exclude direct child robbing
        result[0] = node.val + left[1] + right[1];
        // if not robbing this node then include robbing direct children
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        System.out.println(node.val + ": " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(5);
        System.out.println(rob(t));
    }
}
