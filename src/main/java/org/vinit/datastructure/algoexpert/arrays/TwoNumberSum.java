package org.vinit.datastructure.algoexpert.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // O(n^2) - scan each next number for each number
        // O(nlogn) - sort and search for pair
        // O(n) - hashmap
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(targetSum - array[i]))
                return new int[]{targetSum - array[i], array[i]};
            else
                map.put(array[i], true);
        }
        return new int[0];
    }
}
