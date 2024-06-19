package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Easy_MergeSortedArrays_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int k = nums1.length - 1;
        while (n1 >= 0 && n2 >= 0) {
            int t1 = nums1[n1];
            int t2 = nums2[n2];
            if (t1 > t2) {
                nums1[k] = t1;
                n1--;
            } else {
                nums1[k] = t2;
                n2--;
            }
            k--;
        }
        while (n2 >= 0) {
            nums1[k--] = nums2[n2--];
        }
    }
}
