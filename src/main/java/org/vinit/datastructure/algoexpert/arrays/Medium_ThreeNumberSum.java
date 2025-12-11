package org.vinit.datastructure.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> arrayList = new ArrayList<>();
        for (int currNo = 0; currNo < array.length + 1; currNo++) {
            int leftPtr = currNo + 1;
            int rightPtr = array.length - 1;
            while (leftPtr < rightPtr) {
                int temp = array[currNo] + array[leftPtr] + array[rightPtr];
                if (temp == targetSum) {
                    Integer[] intergers = new Integer[]{array[currNo], array[leftPtr], array[rightPtr]};
                    arrayList.add(intergers);
                    leftPtr++;
                    rightPtr--;
                } else  if (temp > targetSum) {
                    rightPtr--;
                } else {
                    leftPtr++;
                }
            }
        }
        return arrayList.size() > 0 ? arrayList : new ArrayList<Integer[]>();
    }
}
