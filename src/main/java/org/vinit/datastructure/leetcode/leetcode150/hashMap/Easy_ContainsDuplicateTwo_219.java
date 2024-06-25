package org.vinit.datastructure.leetcode.leetcode150.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy_ContainsDuplicateTwo_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            for (Integer x : map.get(nums[i])) {
                if (x != i && nums[x] == nums[i] && Math.abs(i - x) <= k) return true;
            }
            map.get(nums[i]).add(i);
        }
        return false;
    }
}
