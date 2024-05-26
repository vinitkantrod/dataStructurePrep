package org.vinit.datastructure.leetcode.dp;

public class Hard_StudentAttendanceRecordTwo_552 {

    public int checkRecord(int n) {
        int MOD = 1_000_000_007;
        int[][] dpCurrState = new int[2][3];
        int[][] dpNextState = new int[2][3];
        dpCurrState[0][0] = 1;
        for (int len = 0; len < n; len++) {
            for (int totalAbsent = 0; totalAbsent <= 1; totalAbsent++) {
                for (int consecuteLate = 0; consecuteLate <= 2; consecuteLate++) {
                    // consider P
                    dpNextState[totalAbsent][0] = (dpNextState[totalAbsent][0] +
                            dpCurrState[totalAbsent][consecuteLate]) % MOD;

                    // consider A
                    if (totalAbsent < 1) {
                        dpNextState[totalAbsent + 1][0] = (dpNextState[totalAbsent + 1][0] +
                                dpCurrState[totalAbsent][consecuteLate]) % MOD;
                    }
                    // consider L
                    if (consecuteLate < 2) {
                        dpNextState[totalAbsent][consecuteLate + 1] = (dpNextState[totalAbsent][consecuteLate + 1] +
                                dpCurrState[totalAbsent][consecuteLate]) % MOD;
                    }
                }
            }
            System.arraycopy(dpNextState, 0, dpCurrState, 0, dpCurrState.length);
            // Next state sub-problem results will reset to zero.
            dpNextState = new int[2][3];
        }
        // Sum up the counts for all combinations of length 'n' with different absent and late counts.
        int count = 0;
        for (int totalAbsences = 0; totalAbsences <= 1; ++totalAbsences) {
            for (int consecutiveLates = 0; consecutiveLates <= 2; ++consecutiveLates) {
                count = (count + dpCurrState[totalAbsences][consecutiveLates]) % MOD;
            }
        }
        return count;
    }
}
