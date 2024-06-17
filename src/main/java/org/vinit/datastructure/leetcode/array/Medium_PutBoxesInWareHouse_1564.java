package org.vinit.datastructure.leetcode.array;

import java.util.Arrays;

public class Medium_PutBoxesInWareHouse_1564 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int i = boxes.length - 1;
        int count = 0;
        Arrays.sort(boxes);
        for (int room : warehouse) {
            while (i >= 0 && boxes[i] > room) i--;
            if (i == -1) return count;
            count++;
            i--;
        }
        return count;
    }
}
