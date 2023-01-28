package com.github.leetcodedaily.ways_to_make_a_fair_array;

/**
 * @Author Dooby Kim
 * @Date 2023/1/28 10:31 下午
 * @Version 1.0
 */
class Solution {
    public int waysToMakeFair(int[] nums) {
        int res = 0;
        int len = nums.length;
        int[] dp_odd = new int[len];
        int[] dp_even = new int[len];

        dp_odd[0] = nums[0];
        dp_even[0] = 0;

        for (int i = 1; i < len; i++) {
            if (i % 2 == 0) {
                dp_odd[i] = dp_odd[i - 1] + nums[i];
                dp_even[i] = dp_even[i - 1];
            } else {
                dp_even[i] = dp_even[i - 1] + nums[i];
                dp_odd[i] = dp_odd[i - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            int before_odd = i - 1 >= 0 ? dp_odd[i - 1] : 0;
            int after_odd = dp_even[len - 1] - dp_even[i];
            int before_even = i - 1 >= 0 ? dp_even[i - 1] : 0;
            int after_even = dp_odd[len - 1] - dp_odd[i];
            if (before_odd + after_odd == before_even + after_even) res++;
        }

        return res;
    }
}


