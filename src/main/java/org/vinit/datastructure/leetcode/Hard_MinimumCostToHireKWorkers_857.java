package org.vinit.datastructure.leetcode;

import java.util.*;

public class Hard_MinimumCostToHireKWorkers_857 {

    class Pair {
        Double x;
        Integer y;
        public Pair(Double d, Integer i) {
            this.x = d;
            this.y = i;
        }
        public Double getX() {
            return this.x;
        }
        public Integer getY() {
            return this.y;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Priority Queue
        int n = quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        List<Pair> wageToQualityRatio = new ArrayList<>();

        // Calculate wage-to-quality ratio for each worker
        for (int i = 0; i < n; i++) {
            wageToQualityRatio.add(
                    new Pair((double) wage[i] / quality[i], quality[i]));
        }

        // Sort workers based on their wage-to-quality ratio
        Collections.sort(wageToQualityRatio,
                Comparator.comparingDouble(Pair::getX));

        // Use a priority queue to keep track of the highest quality workers
        PriorityQueue<Integer> highestQualityWorkers = new PriorityQueue<>(
                Collections.reverseOrder());

        // Iterate through workers
        for (int i = 0; i < n; i++) {
            highestQualityWorkers.add(wageToQualityRatio.get(i).getY());
            currentTotalQuality += wageToQualityRatio.get(i).getY();

            // If we have more than k workers,
            // remove the one with the highest quality
            if (highestQualityWorkers.size() > k) {
                currentTotalQuality -= highestQualityWorkers.poll();
            }

            // If we have exactly k workers,
            // calculate the total cost and update if it's the minimum
            if (highestQualityWorkers.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality *
                        wageToQualityRatio.get(i).getX());
            }
        }
        return totalCost;
    }
}
