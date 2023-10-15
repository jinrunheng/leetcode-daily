package com.github.leetcodedaily.single_number_ii;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/10/15 10:19 上午
 * @Version 1.0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
