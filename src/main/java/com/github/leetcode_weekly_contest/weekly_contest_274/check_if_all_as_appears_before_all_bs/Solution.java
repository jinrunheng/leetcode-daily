package com.github.leetcode_weekly_contest.weekly_contest_274.check_if_all_as_appears_before_all_bs;

/**
 * @Author Dooby Kim
 * @Date 2022/1/2 10:35 上午
 * @Version 1.0
 */
class Solution {
    public boolean checkString(String s) {
        int indexA = s.length() - 1;
        int indexB = 0;
        while (indexA >= 0 && s.charAt(indexA) != 'a') indexA--;
        while (indexB <= s.length() - 1 && s.charAt(indexB) != 'b') indexB++;
        return indexA <= indexB;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkString("aaabbb"));
    }
}
