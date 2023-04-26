package com.github.leetcodedaily.maximum_sum_of_two_non_overlapping_subarrays;

/**
 * @Author Dooby Kim
 * @Date 2023/4/26 12:18 下午
 * @Version 1.0
 */
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int max = 0;
        for (int i = 0; i + firstLen < prefix.length; i++) {
            max = Math.max(prefix[firstLen + i] - prefix[i] + process(prefix, i + firstLen, secondLen), max);
        }

        for (int i = 0; i + secondLen < prefix.length; i++) {
            max = Math.max(prefix[secondLen + i] - prefix[i] + process(prefix, i + secondLen, firstLen), max);
        }

        return max;
    }

    private int process(int[] prefix, int start, int len) {
        int max = 0;
        for (int i = start; i + len < prefix.length; i++) {
            max = Math.max(max, prefix[i + len] - prefix[i]);
        }
        return max;
    }
}
