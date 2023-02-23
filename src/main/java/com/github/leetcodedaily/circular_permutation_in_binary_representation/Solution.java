package com.github.leetcodedaily.circular_permutation_in_binary_representation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dooby Kim
 * @Date 2023/2/23 10:35 上午
 * @Version 1.0
 */
public class Solution {
    /**
     * 格雷码
     * G = B ^ (B >> 1)
     * B ^= G >> 1
     *
     * @param n
     * @param start
     * @return
     */
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        int size = (int) Math.pow(2, n) - 1;
        for (int i = 0; i <= size; i++) {
            res.add(i ^ (i >> 1) ^ start);
        }
        return res;
    }
}
