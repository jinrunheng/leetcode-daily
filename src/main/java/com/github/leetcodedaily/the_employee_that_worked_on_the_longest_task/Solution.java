package com.github.leetcodedaily.the_employee_that_worked_on_the_longest_task;

/**
 * @Author Dooby Kim
 * @Date 2023/5/5 10:28 下午
 * @Version 1.0
 */
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < logs.length; i++) {
            if (i == 0) {
                max = Math.max(logs[i][1], max);
                res = logs[i][0];
            } else {
                if ((logs[i][1] - logs[i - 1][1]) > max) {
                    max = logs[i][1] - logs[i - 1][1];
                    res = logs[i][0];
                } else if ((logs[i][1] - logs[i - 1][1]) == max) {
                    res = Math.min(logs[i][0], res);
                }
            }
        }
        return res;
    }
}
