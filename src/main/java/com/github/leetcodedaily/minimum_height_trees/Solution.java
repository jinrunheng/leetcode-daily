package com.github.leetcodedaily.minimum_height_trees;

import java.util.*;

/**
 * @Author Dooby Kim
 * @Date 2024/3/17 上午10:17
 * @Version 1.0
 * @Desc 310. 最小高度树
 * @Link https://leetcode.cn/problems/minimum-height-trees/description
 * @Res 超出时间限制
 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            if (map.containsKey(v)) {
                List<Integer> list = map.get(v);
                list.add(u);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(u);
                map.put(v, list);
            }

            if (map.containsKey(u)) {
                List<Integer> list = map.get(u);
                list.add(v);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                map.put(u, list);
            }
        }

        int minHeight = Integer.MAX_VALUE;
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            int height = getHeight(i, map, visited) - 1;
            tmp.put(i, height);
            minHeight = Math.min(height, minHeight);
        }

        for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
            if (entry.getValue() == minHeight) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    private int getHeight(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
        final List<Integer> list = map.get(node);
        int height = 0;
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                height = Math.max(height, getHeight(i, map, visited));
            }
        }
        return 1 + height;
    }


    public static void main(String[] args) {
//        int n = 4;
//        int[][] edges = {
//                {1, 0},
//                {1, 2},
//                {1, 3}
//        };
        int n = 6;
        int[][] edges = {
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}
        };
        Solution solution = new Solution();
        final List<Integer> minHeightTrees = solution.findMinHeightTrees(n, edges);
        for (int i : minHeightTrees) {
            System.out.println(i);
        }
    }

}
