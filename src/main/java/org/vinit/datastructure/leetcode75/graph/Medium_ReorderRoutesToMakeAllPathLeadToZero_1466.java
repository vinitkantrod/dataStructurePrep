package org.vinit.datastructure.leetcode75.graph;

import org.vinit.datastructure.leetcode75.binarySearchTree.Medium_deleteNodeinBST_450;

import java.util.*;

public class Medium_ReorderRoutesToMakeAllPathLeadToZero_1466 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k-> new ArrayList<>())
                    .add(Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k-> new ArrayList<>())
                    .add(Arrays.asList(connection[0], 0));
        }
        bfs(0, n, adj);
        return count;
    }

    private void bfs(int node, int n, Map<Integer, List<List<Integer>>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        boolean[] visited = new boolean[n];
        visited[node] = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (!adj.containsKey(node)) continue;
            for (List<Integer> neighbour : adj.get(node)) {
                int nei = neighbour.get(0);
                int sign = neighbour.get(1);
                if (!visited[nei]) {
                    count += sign;
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
    }
}
