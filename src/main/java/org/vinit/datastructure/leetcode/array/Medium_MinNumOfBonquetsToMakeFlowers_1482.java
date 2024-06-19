package org.vinit.datastructure.leetcode.array;

public class Medium_MinNumOfBonquetsToMakeFlowers_1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0, end = 0;
        for (int d : bloomDay) end = Math.max(end, d);
        int minDays = -1;
        while (start <= end) {
            int mid = (start + end ) / 2;
            if (getNoOfBonquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minDays;
    }

    private int getNoOfBonquets(int[] bloomDay, int mid, int k) {
        int bonquetCount = 0, count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                bonquetCount++;
                count = 0;
            }
        }
        return bonquetCount;
    }
}
