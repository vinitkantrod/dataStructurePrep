package org.vinit.datastructure.leetcode.graph.traversal;

import java.util.*;

public class Medium_ShortestPathWithAlternativeColor_1129 {

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//        int[] result = new int[n];
//        Arrays.fill(result, -1);
//        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();
//        for (int[] e : redEdges)
//            adjList.computeIfAbsent(e[0], k-> new ArrayList<>()).add(
//                    Arrays.asList(e[1], 0)
//            );
//        for (int[] e : blueEdges)
//            adjList.computeIfAbsent(e[0], k-> new ArrayList<>()).add(
//                    Arrays.asList(e[1], 1)
//            );
//
//        boolean[][] visit = new boolean[n][2];
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{0,0,-1});
//        visit[0][0] = visit[0][1] = true;
//        while (!q.isEmpty()) {
//            int[] element = q.poll();
//            int node = element[0];
//            int steps = element[1];
//            int prevColor = element[2];
//            if (!adjList.containsKey(node)) continue;
//            for (List<Integer> nei : adjList.get(node)) {
//                int neighbour = nei.get(0);
//                int color = nei.get(1);
//                if (!visit[neighbour][color] && color != prevColor) {
//                    if (result[neighbour] == -1)
//                        result[neighbour] = 1 + steps;
//                    visit[neighbour][color] = true;
//                    q.offer(new int[]{neighbour, 1 + steps, color})
//                }
//            }
//        }
//        return result;

        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) {
            adj.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(redEdge[1], 0));
        }

        for (int[] blueEdge : blueEdges) {
            adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(blueEdge[1], 1));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visit = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();

        // Start with node 0, with number of steps as 0 and undefined color -1.
        q.offer(new int[] { 0, 0, -1 });
        answer[0] = 0;
        visit[0][1] = visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];

            if (!adj.containsKey(node)) {
                continue;
            }

            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if (!visit[neighbor][color] && color != prevColor) {
                    if (answer[neighbor] == -1)
                        answer[neighbor] = 1 + steps;
                    visit[neighbor][color] = true;
                    q.offer(new int[] { neighbor, 1 + steps, color });
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestAlternatingPaths(
                3, new int[][]{{0,1}, {0,2}},
                new int[][]{}
        )));
    }
}
