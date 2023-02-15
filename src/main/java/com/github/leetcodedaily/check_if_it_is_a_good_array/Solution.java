package com.github.leetcodedaily.check_if_it_is_a_good_array;

/**
 * @Author Dooby Kim
 * @Date 2023/2/15 3:53 下午
 * @Version 1.0
 */
public class Solution {
    public boolean isGoodArray(int[] nums) {
        int tmp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            tmp = gcd(tmp, nums[i]);
        }
        return tmp == 1;
    }

    public int gcd(int a, int b) {
        int res = b;
        while (a % b != 0) {
            res = a % b;
            a = b;
            b = res;
        }
        return res;
    }
}
