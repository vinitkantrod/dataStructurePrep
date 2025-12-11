package org.vinit.datastructure.algoexpert.arrays;

import java.util.List;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        // O(n) | O(1)
//        int leftPointer = 0;
//        int rightPointer = 0;
//        Boolean isSubsequence = false;
//        while (leftPointer < array.size()) {
//            if (rightPointer == sequence.size() - 1 && array.get(leftPointer) == sequence.get(rightPointer)) {
//                isSubsequence = true;
//                break;
//            }
//            if (array.get(leftPointer) == sequence.get(rightPointer)) {
//                rightPointer++;
//            }
//            leftPointer++;
//        }
//        return isSubsequence;

        int seqx = 0;
        for (int value : array) {
            if (seqx == sequence.size()) break;
            if (sequence.get(seqx) == value) seqx++;
        }
        return seqx == sequence.size();
    }
}
