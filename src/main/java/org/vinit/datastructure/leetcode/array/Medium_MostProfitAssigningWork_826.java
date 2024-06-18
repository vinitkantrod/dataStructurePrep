package org.vinit.datastructure.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medium_MostProfitAssigningWork_826 {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Integer[]> jobProfile = new ArrayList<>();
        int n = difficulty.length;
        for (int i = 0; i < n; i++) {
            jobProfile.add(new Integer[]{profit[i], difficulty[i]});
        }
        jobProfile.sort((a,b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < jobProfile.size() - 1; i++) {
            jobProfile.get(i + 1)[1] = Math.min(
                    jobProfile.get(i)[1],
                    jobProfile.get(i + 1)[1]
            );
        }
        int netProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];
            int l = 0, r = worker.length - 1,jobProfit = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (jobProfile.get(mid)[1] <= ability) {
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[0]);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            netProfit += jobProfit;
        }

        return netProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(
                new int[]{2,4,6,8,10},
                new int[]{10,20,30,40,50},
                new int[]{4,5,6,7}
        ));
    }
}
