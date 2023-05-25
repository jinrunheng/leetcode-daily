package com.github.leetcodedaily.odd_string_difference;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/5/25 9:41 下午
 * @Version 1.0
 */
public class Solution {
    public String oddString(String[] words) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length() - 1; j++) {
                sb.append((words[i].charAt(j + 1) - words[i].charAt(j)));
                sb.append("-");
            }

            String s = sb.toString();
            if (map.containsKey(s)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!entry.getKey().equals(s)) {
                        return entry.getValue();
                    }
                }
            } else {
                map.put(s, words[i]);
                if (i == words.length - 1) {
                    return words[i];
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] words = {"abm","bcn","alm"};
        Solution solution = new Solution();
        final String s = solution.oddString(words);
        System.out.println(s);
    }
}
