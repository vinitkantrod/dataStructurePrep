package org.vinit.datastructure.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_MostVisitedSectorInTrack_1560 {

    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                ans.add(i);
            }

            for (int i = start; i <= n; i++) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(List.of(mostVisited(4, new int[]{1,3,1,2})));
    }
}
