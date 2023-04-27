package com.github.leetcodedaily.longest_string_chain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Dooby Kim
 * @Date 2023/4/27 12:21 下午
 * @Version 1.0
 */
public class Solution {
    // dp
    public int longestStrChain(String[] words) {
        List<String> wordList = Arrays.stream(words)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), 1);
        }

        int res = 1;
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (word.length() != 1) {
                int max = 1;
                for (int j = 0; j < word.length(); j++) {
                    String s1 = word.substring(0, j);
                    String s2 = j + 1 < word.length() ? word.substring(j + 1) : "";
                    String pre = s1 + s2;
                    if (map.containsKey(pre)) {
                        max = Math.max(max, map.get(pre) + 1);
                    }
                }
                map.put(word, max);
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
