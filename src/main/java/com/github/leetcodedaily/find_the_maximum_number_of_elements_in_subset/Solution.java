package com.github.leetcodedaily.find_the_maximum_number_of_elements_in_subset;

import java.util.*;

/**
 * @Author Dooby Kim
 * @Date 2024/1/29 10:25 下午
 * @Version 1.0
 */
public class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将所有的 nums 和数量存入到 map 中
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        final Set<Integer> mapKeySet = map.keySet();
        List<Integer> keys = new ArrayList<>(mapKeySet);
        keys.sort(Comparator.comparingInt(o -> o));

        int max = 1;
        for (int i = 0; i < keys.size(); i++) {
            max = Math.max(max, process(keys.get(i), map));
        }
        return max;
    }

    private int process(int init, Map<Integer, Integer> map) {
        int res = 1;
        if (init == 1) {
            int count = map.get(init);
            return count % 2 == 0 ? count - 1 : count;
        }
        while (map.get(init) >= 2 && map.containsKey(init * init)) {
            res += 2;
            init = init * init;
        }
        return res;
    }
}
