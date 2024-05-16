package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

public class Easy_CanPlaceFlower_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                Boolean emptyLeftBed = (i == 0) || (flowerbed[i - 1] == 0);
                Boolean emptyRightBed = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;
                if (emptyLeftBed && emptyRightBed) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) break;
                }
            }
        }
        return count >= n;
    }
}
