package com.github.leetcodedaily.decode_the_message;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/2/1 10:51 上午
 * @Version 1.0
 */
public class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ') {
                map.put(' ', -1);
            }
            if (!map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), start++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                sb.append(' ');
            }else {
                sb.append((char) (map.get(message.charAt(i)) + 'a'));
            }
        }
        return sb.toString();
    }
}
