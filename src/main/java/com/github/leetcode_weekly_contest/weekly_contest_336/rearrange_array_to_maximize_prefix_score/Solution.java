package com.github.leetcode_weekly_contest.weekly_contest_336.rearrange_array_to_maximize_prefix_score;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/3/12 10:46 上午
 * @Version 1.0
 */
public class Solution {
    public int maxScore(int[] nums) {
        // 1. 将 nums 按照从大到小进行排序
        // 2. 前缀和思路,判断正整数的个数
        Integer[] numsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsInteger, (o1, o2) -> o2 - o1);
        long preSum = numsInteger[0];
        if (preSum <= 0) return 0;

        int res = 1;
        for (int i = 1; i < numsInteger.length; i++) {
            preSum += numsInteger[i];
            if (preSum > 0) res++;
            else break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -1, 0, 1, -3, 3, -3};
        Solution sol = new Solution();
        final int i = sol.maxScore(nums);
        System.out.println(i);
    }
}
