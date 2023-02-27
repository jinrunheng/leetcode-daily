package com.github.leetcodedaily.decrease_elements_to_make_array_zigzag;

/**
 * @Author Dooby Kim
 * @Date 2023/2/27 11:06 上午
 * @Version 1.0
 */
public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int res1 = 0;
        int res2 = 0;

        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }

        for (int i = 0; i < tmp.length; i++) {
            if (i % 2 == 0) res1 = getRes(res1, tmp, i);
        }
        for (int i = 0; i < tmp.length; i++) {
            if (i % 2 == 1) res2 = getRes(res2, nums, i++);
        }
        return Math.min(res1, res2);
    }

    private int getRes(int res, int[] tmp, int i) {
        if (i - 1 >= 0 && tmp[i] <= tmp[i - 1]) {
            res += tmp[i - 1] - tmp[i] + 1;
            tmp[i - 1] = tmp[i] - 1;
        }
        if (i + 1 <= tmp.length - 1 && tmp[i] <= tmp[i + 1]) {
            res += tmp[i + 1] - tmp[i] + 1;
            tmp[i + 1] = tmp[i] - 1;
        }
        return res;
    }
}

