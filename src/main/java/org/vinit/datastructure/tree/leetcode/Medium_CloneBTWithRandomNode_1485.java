package org.vinit.datastructure.tree.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Medium_CloneBTWithRandomNode_1485 {
    public class Node {
        int val;
        Node left;
        Node right;
        Node random;
        Node() {}
        Node(int val) { this.val = val; }
    }
    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;
        NodeCopy() {}
        NodeCopy(int val) { this.val = val; }
    }
    Map<Node, NodeCopy> seen;
    public NodeCopy copyRandomBinaryTree(Node root) {
        seen = new HashMap<>();
        return dfs(root);
    }
    private NodeCopy dfs(Node root) {
        if (root == null) return null;
        if (seen.containsKey(root)) return seen.get(root);
        NodeCopy newRoot = new NodeCopy(root.val);
        seen.put(root, newRoot);
        newRoot.left = copyRandomBinaryTree(root.left);
        newRoot.right = copyRandomBinaryTree(root.right);
        newRoot.random = copyRandomBinaryTree(root.random);
        return newRoot;
    }
}
