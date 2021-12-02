package com.github.leetcodedaily.relative_ranks;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 2021.12.2 每日一题
 * <p>
 * 思路为排序 + 模拟
 * 首先遍历数组，然后使用一个 map 将数组对应的数值与当前次序作为 K：V 存储起来
 * 然后对数组按照由大到小的次序进行排序，从 map 中取，将原来位置的数字改为次序即可
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {
        // K : score;V : order
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        // int[] 数组转换为 Integer[] 数组
        Integer[] scoreInteger = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreInteger, Collections.reverseOrder());
        String[] res = new String[score.length];

        for (int i = 0; i < scoreInteger.length; i++) {
            Integer order = map.get(scoreInteger[i]);
            if (i == 0)
                res[order] = "Gold Medal";
            else if (i == 1)
                res[order] = "Silver Medal";
            else if (i == 2)
                res[order] = "Bronze Medal";
            else {
                res[order] = (i + 1) + "";
            }
        }
        return res;
    }
}
