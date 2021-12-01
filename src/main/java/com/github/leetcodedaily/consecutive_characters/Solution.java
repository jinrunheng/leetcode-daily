package com.github.leetcodedaily.consecutive_characters;

/**
 * 2021.12.1 每日一题
 * 思路：一次遍历
 * 维护一个 max 变量，让指针从头至尾遍历字符串；
 * 如果出现重复字符，即更新临时变量 tmp，直至重复字符完结，更新 max 为 max(max,tmp)
 */
class Solution {
    public int maxPower(String s) {
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int tmp = 1;
            while (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                tmp++;
                i++;
            }
            max = Math.max(tmp, max);
        }
        return max;
    }
}
