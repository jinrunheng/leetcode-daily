package com.github.leetcodedaily.maximum_number_of_consecutive_values_you_can_make;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/2/4 8:50 上午
 * @Version 1.0
 */
public class Solution {

    public int getMaximumConsecutive(int[] coins) {
        // If you can make the first x values and you have a value v, then you can make all the values ≤ v + x
        // coins = [1,1,1,4]
        // coins = [1,3]
        Arrays.sort(coins);
        int x = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > x + 1) {
                break;
            } else {
                x += coins[i];
            }
        }
        return x + 1;
    }
}