package com.github.leetcodedaily.make_array_zero_by_subtracting_equal_amounts;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/2/24 11:11 上午
 * @Version 1.0
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) set.add(nums[i]);
        }
        return set.size();
    }
}
