package com.github.leetcode_weekly_contest.weekly_contest_271.rings_and_rods;

class Solution {
    public int countPoints(String rings) {
        int[][] bars = new int[10][3];
        int res = 0;
        for (int i = 0; i < rings.length() - 1; i = i + 2) {
            int color = 0;
            if (rings.charAt(i) == 'G') {
                color = 1;
            } else if (rings.charAt(i) == 'B') {
                color = 2;
            }
            bars[Integer.parseInt(rings.charAt(i + 1) + "")][color]++;
        }
        for (int i = 0; i < bars.length; i++) {
            if (bars[i][0] > 0 && bars[i][1] > 0 && bars[i][2] > 0) {
                res++;
            }
        }
        return res;
    }
}
