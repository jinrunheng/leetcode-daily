package com.github.leetcodedaily.most_frequent_even_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/4/13 8:01 下午
 * @Version 1.0
 */
class Solution {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int res = -1;
        int freq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                    if (map.get(nums[i]) > freq) {
                        freq = map.get(nums[i]);
                        res = nums[i];
                    }
                } else {
                    map.put(nums[i], 1);
                    if (map.get(nums[i]) > freq) {
                        freq = map.get(nums[i]);
                        res = nums[i];
                    }
                }
            }
        }
        return res;
    }
}
