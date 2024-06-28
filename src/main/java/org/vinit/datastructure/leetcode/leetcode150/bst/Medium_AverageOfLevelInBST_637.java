package org.vinit.datastructure.leetcode.leetcode150.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium_AverageOfLevelInBST_637 {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int c = q.size();
            int de = c;
            double avg = 0d;
            while (c > 0) {
                TreeNode node = q.poll();
                avg += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                c--;
            }
            average.add(avg / de);
        }
        return average;
    }
}
