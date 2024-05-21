package org.vinit.datastructure.leetcode.subset;

import java.util.ArrayList;
import java.util.List;

public class Medium_subsets_78 {

    List<List<Integer>> subsets;
    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<>();
        generateAllSubsets(nums, 0, new ArrayList<Integer>());
        return subsets;
    }
    private void generateAllSubsets(int[] nums, int index, List<Integer> set) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(set));
            return;
        }
        // include current element
        set.add(nums[index]);
        generateAllSubsets(nums, index + 1, set);
        set.remove(set.size() - 1);

        // exclude current element
        generateAllSubsets(nums, index + 1, set);
    }
}
