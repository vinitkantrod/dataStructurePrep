package org.vinit.datastructure.leetcode;

import java.util.*;

public class Easy_IntersectionOfThreeSortedArray_1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> s = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();
        for (int i : arr1) s.add(i);
        for (int i : arr2) if (s.contains(i)) s2.add(i);
        for (int i : arr3) if (s2.contains(i)) s3.add(i);
        SortedSet<Integer> sortedS = new TreeSet<>(s3);
        return new ArrayList<>(sortedS);
    }
}
