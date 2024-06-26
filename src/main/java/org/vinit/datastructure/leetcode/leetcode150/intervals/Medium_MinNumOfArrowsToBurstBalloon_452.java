package org.vinit.datastructure.leetcode.leetcode150.intervals;

import java.util.Arrays;

public class Medium_MinNumOfArrowsToBurstBalloon_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int arrow = 1, prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                arrow++;
                prevEnd = points[i][1];
            }
        }
        return arrow;
    }
}
