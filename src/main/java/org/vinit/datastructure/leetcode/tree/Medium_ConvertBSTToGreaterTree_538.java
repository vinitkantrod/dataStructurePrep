package org.vinit.datastructure.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_ConvertBSTToGreaterTree_538 {
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
    public TreeNode convertBST(TreeNode root) {
//        TreeNode rootCopy = root;
//        Map<Integer, TreeNode> nodeMap = new HashMap<>();
//        List<Integer> sortedArr = new ArrayList<>();
//        // create Sorted Array;
//        inOrderTraverse(root, sortedArr, nodeMap);
//        // traverse and update node to greaterNode
//        updateNodeToGreater(sortedArr, nodeMap);
//        return rootCopy;

        int[] nodeSum = new int[1];
        bstToGreater(root, nodeSum);
        return root;
    }
    private void bstToGreater(TreeNode node, int[] nodeSum) {
        if (node == null) return;
        bstToGreater(node.right, nodeSum);
        nodeSum[0] += node.val;
        node.val = nodeSum[0];
        bstToGreater(node.left, nodeSum);
    }

    private void inOrderTraverse(TreeNode node, List<Integer> arr, Map<Integer, TreeNode> map) {
        if (node == null) return;
        inOrderTraverse(node.left, arr, map);
        arr.add(node.val);
        map.put(node.val, node);
        inOrderTraverse(node.right, arr, map);
    }
    private void updateNodeToGreater(List<Integer> arr, Map<Integer, TreeNode> map) {
        if (arr.size() == 0) return;
        int idx = arr.size() - 1;
        int greaterSum = 0;
        while (idx >= 0) {
            int val = arr.get(idx);
            TreeNode originalNode = map.get(val);
            greaterSum += val;
            arr.set(idx, greaterSum);
            originalNode.val = greaterSum;
            idx--;
        }
    }
}
