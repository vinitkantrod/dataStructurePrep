package org.vinit.datastructure.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class Medium_MoveElementToEnd {
    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove
    ) {
        // Write your code here.
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            while (right > left && array.get(right) == toMove) {
                right--;
            }
            if (array.get(left) == toMove) {
                int temp = array.get(right);
                array.set(right, array.get(left));
                array.set(left, temp);
            }
            left++;
        }
        return array;
    }
}
