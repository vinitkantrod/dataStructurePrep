package org.vinit.datastructure.leetcode.leetcode150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_MergeInterval_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        if (intervals.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            if (res.get(res.size()-1)[1] < intervals[i][0]) res.add(intervals[i]);
            else res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
