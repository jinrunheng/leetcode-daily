package com.github.leetcodedaily.widest_vertical_area_between_two_points_containing_no_points;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/3/30 4:19 下午
 * @Version 1.0
 */
public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] tmp = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            tmp[i] = points[i][0];
        }
        Arrays.sort(tmp);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < tmp.length - 1; i++) {
            if (tmp[i + 1] - tmp[i] > res) res = tmp[i + 1] - tmp[i];
        }
        return res;
    }
}
