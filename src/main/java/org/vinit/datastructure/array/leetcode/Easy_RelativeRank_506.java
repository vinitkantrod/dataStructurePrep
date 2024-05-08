package org.vinit.datastructure.array.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Easy_RelativeRank_506 {

    public static String[] findRelativeRanks(int[] score) {
        int[] scoreCopy = Arrays.copyOfRange(score, 0, score.length);
        Arrays.sort(scoreCopy);
        for( int i = 0; i < scoreCopy.length/2; ++i )
        {
            int temp = scoreCopy[i];
            scoreCopy[i] = scoreCopy[scoreCopy.length - i - 1];
            scoreCopy[scoreCopy.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(scoreCopy));
        Map<Integer, Integer> rankMap = new HashMap<>();
        String[] result = new String[score.length];
        for (int i = 0; i < scoreCopy.length; i++) rankMap.put(scoreCopy[i], i + 1);
        System.out.println(rankMap);
        for (int i = 0; i < score.length; i++) {
            if (rankMap.get(score[i]) == 1) result[i] = "Gold Medal";
            else if (rankMap.get(score[i]) == 2) result[i] = "Silver Medal";
            else if (rankMap.get(score[i]) == 3) result[i] = "Bronze Medal";
            else result[i] = "" + rankMap.get(score[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5,4,3,2,1})));
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}
