package org.vinit.datastructure.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Easy_LevelOrderTraversal {

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return;
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                Node node = queue.poll();
                sb.append(node.data + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                count--;
            }
        }
        System.out.println(sb.toString().trim());
    }
}
