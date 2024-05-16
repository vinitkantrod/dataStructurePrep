package org.vinit.datastructure.leetcode.array;

import java.util.PriorityQueue;

public class Medium_KthSmallestPrimeFraction_786 {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new double[]{
                    -1.0 * arr[i] / arr[arr.length - 1],
                    i,
                    arr.length - 1
            });
        }
        while (--k > 0) {
            double[] curr = pq.poll();
            int numeratorIdx = (int) curr[1];
            int denominatorIdx = (int) curr[2] - 1;
            if (denominatorIdx > numeratorIdx) {
                pq.offer(new double[] {
                        -1.0 * arr[numeratorIdx] / arr[denominatorIdx],
                        numeratorIdx,
                        denominatorIdx
                });
            }
        }
        double[] res = pq.poll();
        return new int[]{arr[(int) res[1]], arr[(int) res[2]]};
    }
}
