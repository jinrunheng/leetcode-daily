package com.github.leetcodedaily.sum_multiples;

/**
 * @Author Dooby Kim
 * @Date 2023/10/17 12:38 上午
 * @Version 1.0
 */
public class Solution {
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += getNum(i);
        }
        return res;
    }

    private int getNum(int num) {
        if (num % 3 == 0 || num % 5 == 0 || num % 7 == 0) {
            return num;
        } else {
            return 0;
        }
    }
}
