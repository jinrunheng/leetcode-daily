package com.github.leetcodedaily.check_if_word_is_valid_after_substitutions;

/**
 * @Author Dooby Kim
 * @Date 2023/5/3 9:54 下午
 * @Version 1.0
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        int idx = s.lastIndexOf("abc");
        if (idx == -1) {
            return false;
        } else {
            return isValid(s.substring(0, idx) + s.substring(idx + 3));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abcabcababcc";
        System.out.println(solution.isValid(s));
    }
}
