package org.vinit.datastructure.leetcode.array;

public class Easy_DetermineIfTwoEventHaveConflict_2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Extract start and end times of event1 in minutes
        int startT1 = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int endT1 = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3));

        // Extract start and end times of event2 in minutes
        int startT2 = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3));
        int endT2 = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3));

        // Check if there is an intersection between the two time ranges
        if ((startT1 <= startT2 && startT2 <= endT1) || (startT1 <= endT2 && endT2 <= endT1)) {
            return true;
        } else if ((startT2 <= startT1 && startT1 <= endT2) || (startT2 <= endT1 && endT1 <= endT2)) {
            return true;
        } else {
            return false;
        }
    }
}
