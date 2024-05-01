package org.vinit.datastructure.uberLeetcode;

public class Hard_medianOfTwoSortedArray_4 {

    /**
     * Binary Search Approach O(log(m.n))
     * Two Pointer Approach O(m + n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Two Pointer
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
        // Binary Search
//        int an = nums1.length;
//        int bn = nums2.length;
//        if (bn > an) return findMedianSortedArrays(nums2, nums1);
//        int N = an + bn;
//        if ((an + bn) % 2 == 1) {
//            return getMedian(nums1, nums2, N / 2, 0, an - 1, 0, bn - 1);
//        } else {
//            return (getMedian(nums1, nums2, N / 2, 0, an - 1, 0, bn - 1) +
//                    getMedian(nums1, nums2, (N / 2) - 1, 0, an - 1, 0, bn - 1)) / 2;
//        }
    }

    private static double getMedian(int[] nums1, int[] nums2, int k, int aStart, int aEnd, int bStart, int bEnd) {
        // If the segment of on array is empty, it means we have passed all
        // its element, just return the corresponding element in the other array.
        System.out.println(aStart+"_"+aEnd+"-"+bStart+"_"+bEnd);
        if (aEnd < aStart) {
            return nums2[k - aStart];
        }
        if (bEnd < bStart) {
            return nums1[k - bStart];
        }
        int aIndex = (aStart + aEnd) / 2;
        int bIndex = (bStart + bEnd) / 2;
        int aValue = nums1[aIndex];
        int bValue = nums1[bIndex];
        // If k is in the right half of A + B, remove the smaller left half.
        if (aIndex + bIndex < k) {
            if (aValue > bValue) {
                return getMedian(nums1, nums2, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return getMedian(nums1, nums2, k, aStart, aEnd, bStart, bIndex - 1);
            }
        } else {
            if (aValue > bValue) {
                return getMedian(nums1, nums2, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return getMedian(nums1, nums2, k, aStart, aEnd, bStart, bIndex - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,30,100}, new int[]{2,5,6}));
    }
}
