package com.github.leetcodedaily.truncate_sentence;

class Solution {
    public String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
