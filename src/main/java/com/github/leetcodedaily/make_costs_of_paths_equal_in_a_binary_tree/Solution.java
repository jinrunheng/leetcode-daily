package com.github.leetcodedaily.make_costs_of_paths_equal_in_a_binary_tree;

/**
 * @Author Dooby Kim
 * @Date 2024/2/29 下午11:57
 * @Version 1.0
 */

public class Solution {

    /**
     * 自下而上的思想
     * 1
     * /   \
     * 5     2
     * / \   / \
     * 2  3  3  1
     */
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        int lastNonChildNodeIdx = n / 2 - 1;
        for (int i = lastNonChildNodeIdx; i >= 0; i--) {
            res += Math.abs(cost[2 * i + 1] - cost[2 * i + 2]);
            cost[i] += Math.max(cost[2 * i + 1], cost[2 * i + 2]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        int[] cost = {1, 5, 2, 2, 3, 3, 1};
        final int i = solution.minIncrements(n, cost);
        System.out.println(i);
    }
}
