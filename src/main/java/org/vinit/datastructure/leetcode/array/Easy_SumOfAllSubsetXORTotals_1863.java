package org.vinit.datastructure.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Easy_SumOfAllSubsetXORTotals_1863 {

    static List<List<Integer>> subsetList = new ArrayList<>();
    public static int subsetXORSum(int[] nums) {
//        // TC: O(N.2^N) || SC: O(2^N)
//        // Get all Subset of an array
//        int n = nums.length;
//        getAllSubset(0, nums, new ArrayList<Integer>());
//        // Compute the XOR total for each subset and add to the result
//        int result = 0;
//        for (List<Integer> subset : subsetList) {
//            int subsetXORTotal = 0;
//            for (int num : subset) {
//                subsetXORTotal ^= num;
//            }
//            result += subsetXORTotal;
//        }
//        return result;

//        // O(2^N) || SC: O(N) stack
//        return XORSum(nums, 0, 0);

        // O(N) | O(1)
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }
    private static int XORSum(int[] nums, int index, int currentXORSum) {
        if (index == nums.length) return currentXORSum;
        // Calculate with element included
        int withElement = XORSum(nums, index + 1, currentXORSum ^ nums[index]);
        // calculate without element
        int withoutElement = XORSum(nums, index, currentXORSum);
        return withoutElement + withElement;
    }
    private static void getAllSubset(int i, int[] nums, List<Integer> list) {
        if (i == nums.length) {
            subsetList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        // Generate subset with num
        getAllSubset(i + 1, nums, list);
        list.remove(list.size() - 1);
        // generate subset without num
        getAllSubset(i + 1, nums, list);
    }

    public static void main(String[] args) {
        subsetXORSum(new int[]{1,3});
    }
}
