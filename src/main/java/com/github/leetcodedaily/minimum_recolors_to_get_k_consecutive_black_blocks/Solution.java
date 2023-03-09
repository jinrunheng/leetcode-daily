package com.github.leetcodedaily.minimum_recolors_to_get_k_consecutive_black_blocks;

/**
 * @Author Dooby Kim
 * @Date 2023/3/9 4:59 下午
 * @Version 1.0
 */
public class Solution {

    public int minimumRecolors(String blocks, int k) {
        int[] pre = new int[blocks.length() + 1];
        pre[0] = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                pre[i + 1] = pre[i] + 1;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        int min = k;
        for (int i = 0; i < pre.length - k; i++) {
            min = Math.min(min, (pre[i + k] - pre[i]));
        }
        return min;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        Solution solution = new Solution();
        solution.minimumRecolors(blocks, 7);
    }
}
