package com.github.leetcodedaily.merge_similar_iterms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Dooby Kim
 * @Date 2023/2/28 2:38 下午
 * @Version 1.0
 */
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        initMap(items1, map);
        initMap(items2, map);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            res.add(list);
        }
        return res;
    }

    private void initMap(int[][] items, Map<Integer, Integer> map) {
        for (int i = 0; i < items.length; i++) {
            if (map.containsKey(items[i][0])) {
                map.put(items[i][0], map.get(items[i][0]) + items[i][1]);
            } else {
                map.put(items[i][0], items[i][1]);
            }
        }
    }
}
