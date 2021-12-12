package com.github.leetcode_weekly_contest.weekly_contest_271.sum_of_subarray_ranges;

class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}
