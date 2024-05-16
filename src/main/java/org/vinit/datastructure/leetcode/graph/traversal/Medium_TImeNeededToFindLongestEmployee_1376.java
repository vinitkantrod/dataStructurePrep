package org.vinit.datastructure.leetcode.graph.traversal;

import java.util.*;

public class Medium_TImeNeededToFindLongestEmployee_1376 {

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int maxTime = Integer.MIN_VALUE;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                adjList.get(manager[i]).add(i);
        }
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{headID, 0});

        while (!queue.isEmpty()) {
            Integer[] pair = queue.poll();
            maxTime = Math.max(maxTime, pair[1]);
            for (int adjacent : adjList.get(pair[0]))
                queue.add(new Integer[]{adjacent, pair[1] + informTime[pair[0]]});
        }

        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(numOfMinutes(6,2,new int[]{2,2,-1,1,1,0}, new int[]{4,2,5,0,0,0}));
    }
}
