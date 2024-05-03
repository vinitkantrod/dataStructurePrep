package org.vinit.datastructure.graph.leetcode.dfs;

import java.util.*;

public class Medium_AllPathFromSourceToTarget_797 {

    static int target;
    static int[][] graph;
    static List<List<Integer>> result;
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        target = graph.length - 1;
        graph = graph;
        result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtrack(0, path);
        return result;
    }
    private static void backtrack(int curr, LinkedList<Integer> path) {
        if (curr == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour : graph[curr]) {
            path.addLast(neighbour);
            backtrack(neighbour, path);
            path.removeLast();
        }
    }

//    private static void dfs(Map<Integer, List<Integer>> graph, int curr, int target, Set<Integer> visited) {
//        if (curr == target) {
//            response.add(new ArrayList<>(visited));
//            return;
//        }
//        for (Integer neighbour : graph.get(curr)) {
//            if (visited.contains(neighbour)) continue;
//            visited.add(neighbour);
//            dfs(graph, neighbour, target, visited);
//            visited.remove(neighbour);
//        }
//    }

    public static void main(String[] args) {
        int[][] g = new int[][]{{1,2}, {3}, {3}, {}};
        List<List<Integer>> r = allPathsSourceTarget(g);
        for (List<Integer> rr : r) System.out.println(Arrays.asList(rr));
    }
}
