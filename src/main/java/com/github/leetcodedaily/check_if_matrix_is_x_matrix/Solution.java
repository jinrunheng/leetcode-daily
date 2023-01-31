package com.github.leetcodedaily.check_if_matrix_is_x_matrix;

/**
 * @Author Dooby Kim
 * @Date 2023/1/31 8:32 上午
 * @Version 1.0
 */
public class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isDiagonal(len, i, j) && grid[i][j] == 0) return false;
                if (!isDiagonal(len, i, j) && grid[i][j] != 0) return false;
            }
        }
        return true;
    }


    private boolean isDiagonal(int len, int i, int j) {
        if (i == j || i == len - 1 - j) return true;
        else return false;
    }
}
