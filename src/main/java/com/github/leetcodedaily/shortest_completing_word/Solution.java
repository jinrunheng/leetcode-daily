package com.github.leetcodedaily.shortest_completing_word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> licensePlateMap = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            licensePlateMap.merge(Character.toLowerCase(c), 1, Integer::sum);
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                wordMap.merge(Character.toLowerCase(word.charAt(i)), 1, Integer::sum);
            }
            boolean flag = true;
            for (char c : licensePlate.toCharArray()) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    if (wordMap.get(Character.toLowerCase(c)) != null) {
                        if (wordMap.get(Character.toLowerCase(c)) < licensePlateMap.get(Character.toLowerCase(c))) {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                res.add(word);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            min = Math.min(res.get(i).length(), min);
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).length() == min) {
                return res.get(i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"step", "steps", "stripe", "stepple"};
        solution.shortestCompletingWord("1s3 PSt", words);
    }
}
