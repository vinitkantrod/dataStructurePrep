package org.vinit.datastructure.array.leetcode;

import java.util.*;

public class Easy_IntersectionOfTwoArrays_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set1 = new HashMap<>();
        Map<Integer, Integer> set2 = new HashMap<>();
        int[] temp1 = (nums1.length >= nums2.length) ? nums1 : nums2;
        int[] temp2 = (nums1.length < nums2.length) ? nums1 : nums2;
        for (int i : temp1) set1.put(i, set1.getOrDefault(i, 0) + 1);
        System.out.println(set1);
        int items = 0;
        for (int i : temp2) {
            if (set1.containsKey(i) && set1.get(i)> set2.getOrDefault(i, 0)) {
                set2.put(i, set2.getOrDefault(i, 0) + 1);
                items++;
            }
        }
        int[] res= new int[items];
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : set2.entrySet()) {
            Integer value = entry.getValue();
            while (value > 0) {
                res[c++] = entry.getKey();
                value--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(intersection(new int[]{1,2}, new int[]{1,1})));
    }
}
