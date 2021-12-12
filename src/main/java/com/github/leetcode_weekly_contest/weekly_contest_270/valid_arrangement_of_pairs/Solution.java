package com.github.leetcode_weekly_contest.weekly_contest_270.valid_arrangement_of_pairs;

import java.util.*;

class Solution {

    private Map<Integer, List<Integer>> G = new HashMap<>();
    private Stack<Integer> eulerPath = new Stack<>();

    public int[][] validArrangement(int[][] pairs) {
        // [[5,1],[4,5],[11,9],[9,4]]
        // 5->1,4->5,11->9,9->4
        // 5 的出度为 1，5 的入度为 1
        // 4 的出度为 1，4 的入度为 1
        // 11 的出度为 1，11 的入度为 0
        // 1 的出度为 0，1 的入度为 1
        // pairs[i][0] 表示的是出度，pairs[i][1] 表示的是入度
        // 如果出度比入度大 1，那么该点就是起点
        // 如果入度比出度大 1，那么该点就是终点
        // 如果构成欧拉回路，则所有点的入度与出度都相同，即任意点一个点都可以当成起点
        for (int i = 0; i < pairs.length; i++) {
            G.put(pairs[i][0], new ArrayList<>());
        }
        // 统计入度
        Map<Integer, Integer> in = new HashMap<>();
        // 统计出度
        Map<Integer, Integer> out = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            in.put(pairs[i][1], in.getOrDefault(pairs[i][1], 0) + 1);
            out.put(pairs[i][0], out.getOrDefault(pairs[i][0], 0) + 1);
            G.get(pairs[i][0]).add(pairs[i][1]);
        }

        int start = -1;

        for (Map.Entry<Integer, List<Integer>> entry : G.entrySet()) {
            int v = entry.getKey();
            // 如果出度比入度大，那么该点就是起点
            if (out.get(v) > in.getOrDefault(v, 0)) {
                start = v;
                break;
            }
        }

        if (start == -1)
            start = pairs[0][0];

        dfs(start);

        int[][] res = new int[pairs.length][2];
        for (int i = 0; i < pairs.length; i++) {
            res[i][0] = eulerPath.pop();
            res[i][1] = eulerPath.peek();
        }
        return res;
    }

    private void dfs(int v) {
        List<Integer> list = G.get(v);
        while (list != null && !list.isEmpty()) {
            int w = list.remove(list.size() - 1);
            dfs(w);
        }
        eulerPath.push(v);
    }
}
