package com.github.leetcodedaily.bulls_and_cows;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2024/3/10 下午3:38
 * @Version 1.0
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        StringBuilder secretBuilder = new StringBuilder();
        StringBuilder guessBuilder = new StringBuilder();
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretBuilder.append(secret.charAt(i));
                guessBuilder.append(guess.charAt(i));
            }
        }
        int newLen = secretBuilder.length();
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < newLen; i++) {
            if (!secretMap.isEmpty() && secretMap.containsKey(secretBuilder.charAt(i))) {
                secretMap.put(secretBuilder.charAt(i), secretMap.get(secretBuilder.charAt(i)) + 1);
            } else {
                secretMap.put(secretBuilder.charAt(i), 1);
            }
            if (!guessMap.isEmpty() && guessMap.containsKey(guessBuilder.charAt(i))) {
                guessMap.put(guessBuilder.charAt(i), guessMap.get(guessBuilder.charAt(i)) + 1);
            } else {
                guessMap.put(guessBuilder.charAt(i), 1);
            }
        }
        // 107
        // 710
        for (int i = 0; i < newLen; i++) {
            if (secretMap.containsKey(guessBuilder.charAt(i)) && secretMap.get(guessBuilder.charAt(i)) > 0) {
                cows++;
                secretMap.put(guessBuilder.charAt(i), secretMap.get(guessBuilder.charAt(i)) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        Solution solution = new Solution();
        final String hint = solution.getHint(secret, guess);
        System.out.println(hint);
    }
}
