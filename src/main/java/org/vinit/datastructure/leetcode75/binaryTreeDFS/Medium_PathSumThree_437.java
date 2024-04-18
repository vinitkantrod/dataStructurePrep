package org.vinit.datastructure.leetcode75.binaryTreeDFS;

import java.util.HashMap;
import java.util.Map;

public class Medium_PathSumThree_437 {

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

    int k = 0;
    int count = 0;
    Map<Long, Integer> h = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preOrder(root, 0L);
        return count;
    }
    private void preOrder(TreeNode node, Long currSum) {
        if (node == null) return;
        currSum += node.val;
        if (currSum == k) count += 1;
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        preOrder(node.left, currSum);
        preOrder(node.right, currSum);
        h.put(currSum, h.get(currSum) - 1);
    }

}
