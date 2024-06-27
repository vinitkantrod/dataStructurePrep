package org.vinit.datastructure.leetcode.graph;

public class Easy_CenterOfStarGraph_1791 {

    public int findCenter(int[][] edges) {
//        int eLen = edges.length;
//        int[] nodes = new int[eLen + 2];
//        for (int[] e : edges) {
//            int start = e[0];
//            int end = e[1];
//            nodes[start]++;
//            nodes[end]++;
//        }
//        for (int i = 0; i < nodes.length;i++) {
//            if (nodes[i] >= eLen) return i;
//        }
//        return -1;

        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        return (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1])
                ? firstEdge[0]
                : firstEdge[1];
    }
}
