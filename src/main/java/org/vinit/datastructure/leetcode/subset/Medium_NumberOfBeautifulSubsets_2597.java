package org.vinit.datastructure.leetcode.subset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium_NumberOfBeautifulSubsets_2597 {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return dfs(nums, k, 0, new HashMap<Integer, Integer>());
    }
    private int dfs(int[] nums, int k, int start, Map<Integer, Integer> map) {
        if (start >= nums.length) {
            return 1;
        }
        // ignore current num
        int totalCount = dfs(nums, k, start + 1, map);

        // consider current el
        if (!map.containsKey(nums[start] - k)) {
            map.put(nums[start], map.getOrDefault(nums[start], 0) + 1);
            totalCount += dfs(nums, k, start + 1, map);
            map.put(nums[start], map.get(nums[start]) - 1);
            if (map.get(nums[start]) == 0) map.remove(nums[start]);
        }
        return totalCount;
    }
}
