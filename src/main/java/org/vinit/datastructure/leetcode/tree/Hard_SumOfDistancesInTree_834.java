package org.vinit.datastructure.leetcode.tree;

import java.util.*;

public class Hard_SumOfDistancesInTree_834 {

    static private Map<Integer, List<Integer>> graph;
    static private int[] count;
    static private int[] res;

    private static void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private static void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                res[child] = res[node] - count[child] + (count.length - count[child]);
                dfs2(child, node);
            }
        }
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new HashMap<>();
        count = new int[n];
        res = new int[n];
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(graph);
        dfs(0, -1);
        System.out.println("Count: " + Arrays.toString(count));
        System.out.println("Res: " + Arrays.toString(res));
        dfs2(0, -1);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                sumOfDistancesInTree(6, new int[][]{
                        {0,1},{0,2},{2,3},{2,4},{2,5}
                })
        ));
    }
}
