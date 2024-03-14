package com.github.leetcodedaily.largest_element_in_an_array_after_merge_operations;

/**
 * @Author Dooby Kim
 * @Date 2024/3/14 下午9:58
 * @Version 1.0
 */
public class Solution {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        long res = nums[nums.length - 1];
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (res >= nums[i]) {
                res += nums[i];
            } else {
                res = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 7, 9, 3};
        final long l = solution.maxArrayValue(nums);
        System.out.println(l);
    }
}
