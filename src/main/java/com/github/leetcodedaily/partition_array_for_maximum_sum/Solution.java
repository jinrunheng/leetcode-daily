package com.github.leetcodedaily.partition_array_for_maximum_sum;

/**
 * @Author Dooby Kim
 * @Date 2023/4/19 4:22 下午
 * @Version 1.0
 */
public class Solution {
    // dp
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            int t = 1;
            int curMax = Integer.MIN_VALUE;
            for (int j = i + 1; t <= k && j > 0; j--, t++) {
                curMax = Math.max(curMax, arr[j - 1]);
                max = Math.max(max, dp[i + 1 - t] + curMax * t);
            }
            dp[i + 1] = max;
        }
        return dp[arr.length];
    }
}
