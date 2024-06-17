package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;

public class Medium_PutBoxesInWarehouseTwo_1580 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int N = warehouse.length, leftIndex = 0, rightIndex = N - 1, boxIndex = boxes.length - 1, boxCount = 0;
        Arrays.sort(boxes);
        while (leftIndex <= rightIndex && boxIndex >= 0) {
            if (boxes[boxIndex] <= warehouse[leftIndex]) {
                leftIndex++;
                boxCount++;
            } else if (boxes[boxIndex] <= warehouse[rightIndex]) {
                rightIndex--;
                boxCount++;
            }
            boxIndex--;
        }
        return boxCount;
    }
}
