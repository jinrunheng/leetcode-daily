package com.github.leetcodedaily.binary_trees_with_factors;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/8/29 11:01 下午
 * @Version 1.0
 * @Link https://leetcode.cn/problems/binary-trees-with-factors/
 */
public class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        // 1. 排序
        Arrays.sort(arr);
        // 2. 创建 dp 数组
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);

        long res = 1;

        for (int i = 1; i < arr.length; i++) {

            for (int left = 0, right = i - 1; left <= right; left++) {
                while (right >= left && (long) arr[left] * arr[right] > arr[i]) {
                    right--;
                }
                if (right >= left && (long) arr[left] * arr[right] == arr[i]) {
                    if (right != left) {
                        dp[i] = (dp[i] + dp[left] * dp[right] * 2) % 1000000007;
                    } else {
                        dp[i] = (dp[i] + dp[left] * dp[right]) % 1000000007;
                    }
                }
            }

            res = (res + dp[i]) % 1000000007;

        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {2, 4, 5, 10, 20};
        System.out.println(solution.numFactoredBinaryTrees(input));
    }
}
