package org.vinit.datastructure.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hard_SlidingWindowMedian_480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> resList = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        int j = k - 1;
        List<Integer> temp = new ArrayList<>();
        for (int x = 0; x < k - 1; x++) {
            temp.add(nums[x]);
        }
        Collections.sort(temp);
        while (j < n) {
            int num = nums[j];
            int insertIdx = Collections.binarySearch(temp, num);
            if (insertIdx < 0) {
                insertIdx = -insertIdx - 1;
            }
            temp.add(insertIdx, num);

            if (k % 2 == 1) {
                double median = (double) temp.get(k / 2);
                resList.add(median);
            } else {
                int idx = k / 2;
                double median1 = (double) temp.get(idx);
                double median2 = (double) temp.get(idx - 1);
                resList.add((median1 + median2) / 2);
            }

            int removeIdx = Collections.binarySearch(temp, nums[i]);
            if (removeIdx < 0) {
                removeIdx = -removeIdx - 1;
            }
            temp.remove(removeIdx);

            i++;
            j++;
        }

        double[] resArray = new double[resList.size()];
        for (int x = 0; x < resList.size(); x++) {
            resArray[x] = resList.get(x);
        }

        return resArray;

        // O(nlogk) + O(n) || SC: O(k)
//        List<Double> resList = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        int n = nums.length;
//        int i = 0;
//        int j = k - 1;
//        for (int x = 0; x < k - 1; x++) temp.add(nums[x]);
//        Collections.sort(temp);
//        while (j < n) {
//            int num = nums[j];
//            int insertIdx = Collections.binarySearch(temp, num);
//            if (insertIdx < 0) insertIdx = -insertIdx - 1;
//
//            temp.add(insertIdx, num);
//
//            if (k % 2 == 1) {
//                resList.add((double) temp.get(k / 2));
//            } else {
//                int m1 = temp.get(k / 2);
//                int m2 = temp.get((k / 2) - 1);
//                resList.add((m1 + m2)/2.0);
//            }
//
//            int removeIdx = Collections.binarySearch(temp, nums[i]);
//            if (removeIdx < 0) removeIdx = -removeIdx - 1;
//            temp.remove(removeIdx);
//            j++;
//            i++;
//        }
//        double[] response = new double[resList.size()];
//        for (int x = 0; x < resList.size(); x++) response[x] = resList.get(x);
//        return response;

    }
}
