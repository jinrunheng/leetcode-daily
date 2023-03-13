package com.github.leetcode_weekly_contest.weekly_contest_336.count_the_number_of_vowel_strings_in_range;

/**
 * @Author Dooby Kim
 * @Date 2023/3/12 10:36 上午
 * @Version 1.0
 */
public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isVowelString(words[i])) res++;
        }
        return res;
    }

    private boolean isVowelString(String word) {
        int len = word.length();
        if ((word.charAt(0) == 'a' ||
                word.charAt(0) == 'e' ||
                word.charAt(0) == 'i' ||
                word.charAt(0) == 'o' ||
                word.charAt(0) == 'u')
                && (word.charAt(len - 1) == 'a' ||
                word.charAt(len - 1) == 'e' ||
                word.charAt(len - 1) == 'i' ||
                word.charAt(len - 1) == 'o' ||
                word.charAt(len - 1) == 'u')
        ) return true;
        else return false;
    }
}
