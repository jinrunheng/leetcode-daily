package com.github.leetcodedaily.flip_columns_for_maximum_number_of_equal_rows;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/5/15 8:34 下午
 * @Version 1.0
 */
public class Solution {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int res = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
            String str = sb.toString();
            final String flip = flip(str);
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else if (map.containsKey(flip)) {
                map.put(flip, map.get(flip) + 1);
            } else {
                map.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            final Integer value = entry.getValue();
            res = Math.max(res, value);
        }
        return res;
    }

    private String flip(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}
