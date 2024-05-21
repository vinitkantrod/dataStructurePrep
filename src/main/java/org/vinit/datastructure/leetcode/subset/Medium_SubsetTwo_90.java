package org.vinit.datastructure.leetcode.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_SubsetTwo_90 {

    List<List<Integer>> subsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort array
        subsets = new ArrayList<>();
        generateAllSubsets(nums, 0, new ArrayList<Integer>());
        return subsets;
    }
    private void generateAllSubsets(int[] nums, int index, List<Integer> set) {
        subsets.add(new ArrayList<>(set));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;     // Skip if same element repeated
            set.add(nums[i]);
            generateAllSubsets(nums, i + 1, set);
            set.remove(set.size() - 1);
        }
    }
}
