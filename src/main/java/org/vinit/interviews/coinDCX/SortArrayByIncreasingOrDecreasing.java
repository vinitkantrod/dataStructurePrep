package org.vinit.interviews.coinDCX;

/**
 * EG:
 * arr1 = [9,8,7,5,2,3,3]
 * arr2 = [0,1,2,3,5,7,5,6]
 *
 * min cost to change the value such that array is sorted in asc or desc
 *
 * in arr1: changing 2 to 3, cost is 1
 * in arr2: changing 5 to 6, cost is 1
 */
public class SortArrayByIncreasingOrDecreasing {

    public static int modifyArray(int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(modifyArray(new int[]{9,8,7,2,3,3}));
        System.out.println(modifyArray(new int[]{0,1,2,3,5,6,5,7}));
    }
}
