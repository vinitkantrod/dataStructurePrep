package org.vinit.datastructure.algoexpert.arrays;

public class Easy_SortedSquareArray {

    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        // Square and sort - O(n) + O(nlogn) ~ O(n)
        // O(n) - 2 pointer
        int size = array.length;
        int left = 0;
        int right = size - 1;

        int[] output = new int[size];
        int insertIndex = size - 1;
        while (left <= right) {
            int leftSquare = array[left] * array[left];
            int rightSquare = array[right] * array[right];
            if (leftSquare > rightSquare) {
                output[insertIndex--] = leftSquare;
                left++;
            }
            else {
                output[insertIndex--] = rightSquare;
                right--;
            }
        }
        return output;
    }
}
