package org.vinit.datastructure.leetcode.leetcode.disjointSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium_LexicographicallySmallestEquivalentString_1061 {

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] graph = new int[26];
        for (int i = 0; i < 26; i++) graph[i] = i;

        System.out.println(Arrays.toString(graph));
        for (int i = 0; i < s1.length(); i++) union(graph, s1.charAt(i) - 'a', s2.charAt(i) - 'a');

        System.out.println("Graph after " + Arrays.toString(graph));
        String ans = "";
        for (char c : baseStr.toCharArray()) {
             ans += (char) (find(graph, (c - 'a')) + 'a');
        }
        return ans;
    }
    private static int find(int[] graph, int x) {
        if (graph[x] == x) return x;
        return graph[x] = find(graph, graph[x]);
    }
    private static void union(int[] graph, int x, int y) {
        x = find(graph, x);
        y = find(graph, y);
        System.out.println("U: " + x + ", " + y);
        if (x == y) return;
        if (x < y) graph[y] = x;
        else graph[x] = y;
    }

    public static void main(String[] args) {
//        System.out.println(smallestEquivalentString("parker","morris","parser"));
//        System.out.println(smallestEquivalentString("abc","cde","eed"));
        System.out.println(smallestEquivalentString("leetcode","programs","sourcecode"));
    }
}
