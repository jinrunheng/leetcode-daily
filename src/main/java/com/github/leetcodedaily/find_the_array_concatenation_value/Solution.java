package com.github.leetcodedaily.find_the_array_concatenation_value;

/**
 * @Author Dooby Kim
 * @Date 2023/10/12 4:24 下午
 * @Version 1.0
 */
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        long res = 0;
        while (p <= q) {
            if (p == q) {
                res += nums[p];
                break;
            } else {
                String tmp = "" + (nums[p++]) + (nums[q--]);
                res += Long.parseLong(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testArr = {7, 52, 2, 4};
        final long theArrayConcVal = solution.findTheArrayConcVal(testArr);
        System.out.println(theArrayConcVal);
    }
}
