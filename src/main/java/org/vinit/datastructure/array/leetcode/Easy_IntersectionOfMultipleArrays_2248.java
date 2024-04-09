package org.vinit.datastructure.array.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy_IntersectionOfMultipleArrays_2248 {

    public List<Integer> intersection(int[][] nums) {
        int[] result = new int[1001];
        int rowCount = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int num = nums[i][j];
                result[num]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == rowCount) {
                res.add(result[i]);
            }
        }
        return res;
    }
}
