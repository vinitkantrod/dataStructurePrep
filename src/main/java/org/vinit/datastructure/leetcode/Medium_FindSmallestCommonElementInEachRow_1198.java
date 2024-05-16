package org.vinit.datastructure.leetcode;

import java.util.*;

public class Medium_FindSmallestCommonElementInEachRow_1198 {

    public int smallestCommonElement(int[][] mat) {
        Set<Integer> mainSet = new HashSet<>();
        if (mat.length == 0) return -1;
        for (int i : mat[0]) mainSet.add(i);
        if (mat.length == 1) return mat[0][0];
        for (int i = 1; i < mat.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < mat[0].length; j++) {
                if (mainSet.contains(mat[i][j]))
                    temp.add(mat[i][j]);
            }
            mainSet = temp;
        }
        SortedSet<Integer> sortedVersion = new TreeSet<>(mainSet);
        return !sortedVersion.isEmpty() ? sortedVersion.first() : -1;
    }
}
