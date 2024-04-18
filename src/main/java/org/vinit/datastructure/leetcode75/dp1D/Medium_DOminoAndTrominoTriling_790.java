package org.vinit.datastructure.leetcode75.dp1D;

public class Medium_DOminoAndTrominoTriling_790 {

    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) return n;
        long[] f = new long[n + 1];
        long[] p = new long[n + 1];
        f[1] = 1L;
        f[2] = 2L;
        p[2] = 1L;
        for (int k = 3; k <= n; k++) {
            f[k] = (f[k - 1] + f[k - 2]+ 2*p[k - 1]) % MOD;
            p[k] = (p[k - 1] + p[k - 2]) % MOD;
        }
        return (int) f[n];
    }
}
