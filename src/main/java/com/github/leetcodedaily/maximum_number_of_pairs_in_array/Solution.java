package com.github.leetcodedaily.maximum_number_of_pairs_in_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/2/16 8:43 下午
 * @Version 1.0
 */
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            pairs += value / 2;
        }
        int[] res = new int[2];
        res[0] = pairs;
        res[1] = nums.length - pairs * 2;
        return res;
    }
}
