package com.github.leetcode_weekly_contest.weekly_contest_272.find_first_palindromic_string_in_the_array;

class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words)
            if (isPalindrome(word)) return word;

        return "";
    }

    public boolean isPalindrome(String word) {
        StringBuilder reverse = new StringBuilder(word).reverse();
        if (reverse.toString().equals(word)) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        solution.firstPalindrome(words);
    }
}
