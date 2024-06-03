package org.vinit.datastructure.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Did not understood the solution. My solution was coming around O(m^2.n).
 * This is the solution from the discussion section of 1713 problem statement
 */
public class Hard_MinimumOperationToMakeASubsequence_1713 {
    public int minOperations(int[] target, int[] arr) {
        List<Integer> tails = new ArrayList<>();
        Map<Integer, Integer> positions = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            positions.put(target[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (tails.isEmpty() && positions.containsKey(arr[i])) {
                tails.add(positions.get(arr[i]));
            } else if (!tails.isEmpty() && (positions.containsKey(arr[i]))) {
                if (tails.get(tails.size() - 1) < positions.get(arr[i])) {
                    tails.add(positions.get(arr[i]));
                } else {
                    tails.set(this.upperBound(tails, positions.get(arr[i]), 0, tails.size() - 1), positions.get(arr[i]));
                }
            }
        }

        return target.length - tails.size();
    }

    private int upperBound(List<Integer> domain, int value, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (domain.get(mid) == value) {
            return mid;
        } else if (domain.get(mid) < value) {
            left = mid + 1;
        } else {
            right = mid;
        }

        return this.upperBound(domain, value, left, right);
    }
}
