package com.github.leetcodedaily.super_pow;

class Solution {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        // a = 2; b = [4,3,3,8,5,2]
        // res = 2^400000 * 2^30000 * 2^3000 * 2^800 * 2^50 * 2^2
        // res = (2^100000)^4 * (2^10000)^3 * (2^1000)^3 * (2^100)^8 * (2^10)^5 * (2^1)^2
        // 从后向前进行遍历
        int res = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            res = (int) ((long) res * myPow(a, b[i]) % MOD);
            a = myPow(a, 10);
        }
        return res;
    }

    private int myPow(int x, int n) {
        if (n == 0)
            return 1;

        if (n % 2 == 0)
            return myPow((x % MOD) * (x % MOD), n / 2);
        else
            return (myPow(x, n - 1) * (x % MOD)) % MOD;
    }
}
