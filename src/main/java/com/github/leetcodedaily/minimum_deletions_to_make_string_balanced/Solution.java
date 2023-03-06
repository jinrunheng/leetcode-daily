package com.github.leetcodedaily.minimum_deletions_to_make_string_balanced;

/**
 * @Author Dooby Kim
 * @Date 2023/3/6 12:21 下午
 * @Version 1.0
 */
public class Solution {
    public int minimumDeletions(String s) {
        int[] preA = new int[s.length()];
        int[] subB = new int[s.length()];

        preA[0] = s.charAt(0) == 'a' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            preA[i] = preA[i - 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        subB[s.length() - 1] = s.charAt(s.length() - 1) == 'b' ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            subB[i] = subB[i + 1] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            min = Math.min(min, (s.length() - preA[i] - subB[i]));
        }
        return min;
    }
}
