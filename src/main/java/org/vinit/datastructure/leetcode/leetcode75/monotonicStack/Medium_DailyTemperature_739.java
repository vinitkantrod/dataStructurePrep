package org.vinit.datastructure.leetcode.leetcode75.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Medium_DailyTemperature_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for(int currDay = 0; currDay < n; currDay++) {
            int currTemp = temperatures[currDay];
            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
//        for (int i = 0; i < temperatures.length; i++) {
//            int currTemp = temperatures[i];
//            int j = i;
//            while (j < temperatures.length) {
//                if (temperatures[j] > currTemp) {
//                    result[i] = j - i;
//                    break;
//                }
//                j++;
//            }
//        }
        return result;
    }
}
