package org.vinit.datastructure.twoPointers.runningFromBothEnd.twoSumPatterns;

public class Easy_SumOfSquareNumbers_633 {

    public boolean judgeSquareSum(int c) {
        int N = (int) Math.floor(Math.sqrt(c));
        int left = 0;
        int right = N;
        while (left <= right) {
            Double leftPow = Math.pow(left, 2);
            Double rightPow = Math.pow(right, 2);
            Double powSum = leftPow + rightPow;
            if (powSum == c) return true;
            else if (powSum < c) left++;
            else right--;
        }
        return false;
    }
}
