package com.github.leetcodedaily.tuple_with_same_product;

import java.util.*;

/**
 * @Author Dooby Kim
 * @Date 2023/10/19 1:53 上午
 * @Version 1.0
 */
public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = nums[i] * nums[j];
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }

        int res = 0;
        for (Integer v : map.values()) {
            res += v < 2 ? 0 : (v) * (v - 1) * 4;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 10};
        Solution solution = new Solution();
        final int i = solution.tupleSameProduct(nums);
        System.out.println(i);
    }
}
