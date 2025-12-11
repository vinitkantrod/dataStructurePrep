package org.vinit.datastructure.algoexpert.arrays;

import java.util.Arrays;

public class Medium_SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int i = 0;
        int j = 0;
        int smallestDiff = Integer.MAX_VALUE;
        int num1 = arrayOne[0];
        int num2 = arrayTwo[0];
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (i > arrayOne.length || j > arrayTwo.length) break;
            if (Math.abs(arrayOne[i] - arrayTwo[j]) < smallestDiff) {
                smallestDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
                num1 = arrayOne[i];
                num2 = arrayTwo[j];
            }
            if (arrayOne[i] > arrayTwo[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] ints = {num1, num2};
        return ints;
    }
}
