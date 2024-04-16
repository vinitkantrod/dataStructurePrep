package org.vinit.datastructure.leetcode75.arrayStrings;

import java.util.ArrayList;
import java.util.List;

public class Easy_KidWithGreatestCandies_1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumber = 0;
        for (int i : candies) if (i > maxNumber) maxNumber = i;
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies) >= maxNumber);
        }
        return result;
    }
}
