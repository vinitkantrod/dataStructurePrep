package org.vinit.datastructure.leetcode.graph;

import java.util.*;

public class Medium_AllAncestorOfNodeInDirectedAcyclicGraph_2192 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] e : edges) {
            adjList[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int currNode = q.poll();
            topologicalOrder.add(currNode);
            for (int neighbour : adjList[currNode]) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) q.offer(neighbour);
            }
        }

        List<List<Integer>> ancestorList = new ArrayList<>();
        List<Set<Integer>> ancestorSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorList.add(new ArrayList<>());
            ancestorSetList.add(new HashSet<>());
        }

        for (int node : topologicalOrder) {
            for (int neighbour : adjList[node]) {
                ancestorSetList.get(neighbour).add(node);
                ancestorSetList
                        .get(neighbour)
                        .addAll(ancestorSetList.get(node));
            }
        }

        for (int i = 0; i < ancestorList.size(); i++) {
            ancestorList.get(i).addAll(ancestorSetList.get(i));
            Collections.sort(ancestorList.get(i));
        }

        return ancestorList;
    }
}
