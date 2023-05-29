package com.github.leetcodedaily.average_value_of_even_numbers_that_are_divisible_by_three;

/**
 * @Author Dooby Kim
 * @Date 2023/5/29 10:12 下午
 * @Version 1.0
 */
public class Solution {

    public int averageValue(int[] nums) {
        int t = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 2 == 0) {
                t += nums[i];
                c++;
            }
        }
        if (c == 0) return 0;
        return t / c;
    }
}
