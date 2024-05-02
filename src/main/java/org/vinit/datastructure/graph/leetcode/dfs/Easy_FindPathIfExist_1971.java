package org.vinit.datastructure.graph.leetcode.dfs;

import java.util.*;

public class Easy_FindPathIfExist_1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // prepare adjacency List
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        boolean isPathExist = dfs(graph, source, destination, visited);
        return isPathExist;
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, Set<Integer> visited) {
        if (current == destination) return true;
        visited.add(current);
        for (Integer neighbour : graph.get(current)) {
            if (visited.contains(neighbour)) continue;
            boolean path = dfs(graph, neighbour, destination, visited);
            if (path) return true;
        }
        return false;
    }
}
