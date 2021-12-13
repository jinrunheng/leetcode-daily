package com.github.leetcodedaily.max_increase_to_keep_city_skyline;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] leftMax = new int[grid[0].length];
        int[] frontMax = new int[grid.length];

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            frontMax[i] = max;
        }

        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            leftMax[i] = max;
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != frontMax[j] && grid[i][j] != leftMax[i]) {
                    res += Math.min(leftMax[i], frontMax[j]) - grid[i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        solution.maxIncreaseKeepingSkyline(grid);
    }
}
