package org.vinit.algoexpert.coding.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy_TwoNumberSum_1 {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // sort array
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (sumMap.containsKey(targetSum - array[i])) {
                result[0] = array[i];
                result[1] = targetSum - array[i];
                return result;
            } else {
                sumMap.put(array[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
