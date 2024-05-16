package org.vinit.datastructure.leetcode.tree;

public class Medium_ConvertBinarySearchTreeToSortedDoubleCircularLinkedList_426 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }
    private void helper(Node root) {
        if (root != null) {
            helper(root.left);
            if (last != null) {
                last.right = root;
                root.left = last;
            } else {
                first = root;
            }
            last = root;
            helper(root.right);
        }
    }
}
