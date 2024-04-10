package org.vinit.datastructure.twoPointers.runningFromBothEnd.twoSumPatterns;

import java.util.Arrays;

public class Medium_BoatToSavePeople_881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boatCount = 0;
        while ( i <= j) {
            boatCount++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return boatCount;
    }
}
