package com.github.leetcodedaily.maximum_number_of_moves_in_a_grid;

/**
 * @Author Dooby Kim
 * @Date 2024/3/16 上午12:39
 * @Version 1.0
 */
public class Solution {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        // init
        for (int i = 0; i < row; i++) {
            dp[i][col - 1] = 0;
        }
        for (int i = col - 2; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                dp[j][i] = process(grid, dp, j, i);
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            res = Math.max(dp[i][0], res);
        }
        return res;
    }

    private int process(int[][] grid, int[][] dp, int curRow, int curCol) {
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        int val = grid[curRow][curCol];
        if (curRow - 1 >= 0) {
            if (grid[curRow - 1][curCol + 1] > val) {
                res1 = dp[curRow - 1][curCol + 1] + 1;
            }
        }
        if (grid[curRow][curCol + 1] > val) {
            res2 = dp[curRow][curCol + 1] + 1;
        }
        if (curRow + 1 < grid.length) {
            if (grid[curRow + 1][curCol + 1] > val) {
                res3 = dp[curRow + 1][curCol + 1] + 1;
            }
        }
        return Math.max(res1, Math.max(res2, res3));
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        Solution solution = new Solution();
        final int i = solution.maxMoves(grid);
        System.out.println(i);
    }
}
