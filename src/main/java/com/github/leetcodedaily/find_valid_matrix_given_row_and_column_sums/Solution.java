package com.github.leetcodedaily.find_valid_matrix_given_row_and_column_sums;

/**
 * @Author Dooby Kim
 * @Date 2023/3/14 11:25 上午
 * @Version 1.0
 */
public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowLen = rowSum.length;
        int colLen = colSum.length;
        int[][] res = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                colSum[j] -= res[i][j];
                rowSum[i] -= res[i][j];
            }
        }
        return res;
    }
}
