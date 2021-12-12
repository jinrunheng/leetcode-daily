package com.github.leetcode_weekly_contest.weekly_contest_271.maximum_fruits_harvested_aftter_at_most_k_steps;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 500000;
        int[] sum = new int[max];
        int fruitsIndex = 0;
        int curSum = 0;
        for (int i = 0; i < sum.length; i++) {
            if (fruitsIndex < fruits.length && i == fruits[fruitsIndex][0]) {
                curSum += fruits[fruitsIndex][1];
                fruitsIndex++;
            }
            sum[i] = curSum;
        }

        int res = 0;
        for (int i = 0; i <= k; i++) {
            int left = Math.max(0, startPos - i);
            int right = Math.min(max, left + (k - i));
            res = Math.max(res, sum[right] - (left == 0 ? 0 : sum[left - 1]));
        }
        for (int i = 0; i <= k; i++) {
            int right = startPos + i;
            int left = Math.max(0, right - (k - i));
            res = Math.max(res, sum[right] - (left == 0 ? 0 : sum[left - 1]));
        }
        return res;
    }
}