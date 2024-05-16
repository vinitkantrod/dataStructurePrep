package org.vinit.datastructure.leetcode.leetcode75.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class Medium_MaxNumberOfKPairSum_1679 {

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int kPair = 0;
        for (int i = 0; i < nums.length;i++) {
            if (map.containsKey(k - nums[i])) {
                int val = map.get(k - nums[i]);
                map.put(k- nums[i], val - 1);
                if (val == 1) map.remove(k - nums[i]);
                kPair++;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return kPair;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
    }
}
