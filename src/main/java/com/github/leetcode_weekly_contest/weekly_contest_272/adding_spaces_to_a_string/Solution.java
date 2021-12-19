package com.github.leetcode_weekly_contest.weekly_contest_272.adding_spaces_to_a_string;

import java.util.Arrays;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        Arrays.sort(spaces);
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                sb.append(" ");
                sb.append(s.charAt(i));
                j++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        Solution solution = new Solution();
        String res = solution.addSpaces(s, spaces);
        System.out.println(res);
    }
}
