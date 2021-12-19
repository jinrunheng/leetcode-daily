package com.github.leetcode_weekly_contest.weekly_contest_272.number_of_smooth_descent_periods_of_a_stock;

class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int j = 0;
        for (int i = 0; i < prices.length; i = j + 1) {
            j = i;
            while (j < prices.length - 1 && prices[j] - prices[j + 1] == 1) {
                j++;
            }
            res += count1ToN(j - i + 1);
        }
        return res;
    }

    public long count1ToN(long n) {
        return ((1 + n) * n) / 2;
    }

    public static void main(String[] args) {
        // int[] prices = {3, 2, 1, 4};
        // int[] prices = {1};
        int[] prices = {8, 6, 7, 7};
        Solution solution = new Solution();
        long descentPeriods = solution.getDescentPeriods(prices);
        System.out.println(descentPeriods);
    }
}
