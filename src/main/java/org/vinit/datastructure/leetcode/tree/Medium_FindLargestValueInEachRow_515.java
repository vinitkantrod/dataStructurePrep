package org.vinit.datastructure.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium_FindLargestValueInEachRow_515 {

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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int c = q.size();
            int maxEle = Integer.MIN_VALUE;
            while (c > 0) {
                TreeNode t = q.poll();
                maxEle = Math.max(maxEle, t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
                c--;
            }
            res.add(maxEle);
        }
        return res;
    }
}
