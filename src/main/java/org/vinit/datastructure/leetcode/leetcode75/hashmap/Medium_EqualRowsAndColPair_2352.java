package org.vinit.datastructure.leetcode.leetcode75.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Medium_EqualRowsAndColPair_2352 {

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                sb.append("" + grid[i][j] + "_");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        System.out.println(map);
        int pairCount = 0;
        for (int i = 0; i < grid[0].length;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                System.out.println(i + "-" + j);
                sb.append("" + grid[j][i] + "_");
            }
            System.out.println(sb.toString());
            if (map.containsKey(sb.toString())) pairCount += map.get(sb.toString());
        }
        return pairCount;

    }

    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
    }
}
