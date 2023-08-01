package com.github.leetcodedaily.card_flipping_game;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/8/2 1:14 上午
 * @Version 1.0
 */
public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> count = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            count.add(fronts[i]);
            count.add(backs[i]);
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        if (count.size() == set.size()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!set.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }

            if (!set.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        return min;
    }
}
