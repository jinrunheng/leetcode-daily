package com.github.leetcode_weekly_contest.weekly_contest_270.finding_3_even_numbers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && i != k && j != k && digits[i] != 0) {
                        int n = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (n % 2 == 0) set.add(n);
                    }
                }
            }
        }
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
