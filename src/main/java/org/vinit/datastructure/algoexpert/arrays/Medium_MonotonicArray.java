package org.vinit.datastructure.algoexpert.arrays;

public class Medium_MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if (array.length <= 1) return true;
        Boolean shouldIncrease = false;
        Boolean shouldDecrease = false;
        for (int i = 1; i < array.length; i++) {
            if (!shouldIncrease && !shouldDecrease) {
                if (array[i] > array[i - 1]) shouldIncrease = true;
                if (array[i] < array[i - 1]) shouldDecrease = true;
            } else if (shouldIncrease && array[i] < array[i - 1]) return false;
            else if (shouldDecrease && array[i] > array[i - 1]) return false;
        }
        return true;
    }
}
