package com.github.leetcodedaily.number_of_arithmetic_triplets;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/3/31 10:24 上午
 * @Version 1.0
 */
public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + diff) && set.contains(nums[i] + diff + diff)) {
                res++;
            }
        }
        return res;
    }
}
