package com.github.leetcodedaily.largest_local_values_in_a_matrix;

/**
 * @Author Dooby Kim
 * @Date 2023/3/1 1:03 下午
 * @Version 1.0
 */
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] res = new int[len - 2][len - 2];
        for (int i = 1; i < len - 1; i++) {
            for (int j = 1; j < len - 1; j++) {
                res[i - 1][j - 1] = getMax(i, j, grid);
            }
        }
        return res;
    }

    private int getMax(int x, int y, int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}
