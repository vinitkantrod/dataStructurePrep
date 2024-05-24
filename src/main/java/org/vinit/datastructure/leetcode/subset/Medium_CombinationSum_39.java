package org.vinit.datastructure.leetcode.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_CombinationSum_39 {
    List<List<Integer>> combination = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0, candidates, target, new ArrayList<>());
        return combination;
    }
    private void backtrack(int index, int[] candidates, int target, List<Integer> subset) {
        if (target < 0) return;
        if (index >= candidates.length) return;
        if (target == 0) {
            combination.add(new ArrayList<>(subset));
            return;
        }
        // consider current element
        subset.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], subset);
        subset.remove(subset.size() - 1);

        // ignore current element
        backtrack(index + 1, candidates, target, subset);

    }
}
