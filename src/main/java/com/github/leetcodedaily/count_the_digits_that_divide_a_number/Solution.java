package com.github.leetcodedaily.count_the_digits_that_divide_a_number;

/**
 * @Author Dooby Kim
 * @Date 2023/10/26 6:43 下午
 * @Version 1.0
 */
public class Solution {
    public int countDigits(int num) {
        final String s = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = (int) s.charAt(i) - 48;
            if (n != 0 && num % n == 0) {
                count++;
            }
        }
        return count;
    }
}
