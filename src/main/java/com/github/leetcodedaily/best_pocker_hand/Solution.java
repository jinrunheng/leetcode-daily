package com.github.leetcodedaily.best_pocker_hand;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/2/20 5:20 下午
 * @Version 1.0
 */
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> ranksMap = new HashMap<>();
        Set<Character> suitsSet = new HashSet<>();
        for (int i = 0; i < ranks.length; i++) {
            if (ranksMap.containsKey(ranks[i])) {
                ranksMap.put(ranks[i], ranksMap.get(ranks[i]) + 1);
            } else {
                ranksMap.put(ranks[i], 1);
            }
            suitsSet.add(suits[i]);
        }

        if (isFlush(suitsSet)) return "Flush";
        if (isThreeOfAKind(ranksMap)) return "Three of a Kind";
        if (isHighCard(ranksMap)) return "High Card";
        return "Pair";
    }

    boolean isFlush(Set<Character> suitsSet) {
        if (suitsSet.size() == 1) return true;
        return false;
    }

    boolean isHighCard(Map<Integer, Integer> ranksMap) {
        if (ranksMap.size() == 5) return true;
        return false;
    }

    boolean isThreeOfAKind(Map<Integer, Integer> ranksMap) {
        for (Map.Entry<Integer, Integer> entry : ranksMap.entrySet()) {
            if (entry.getValue() >= 3) {
                return true;
            }
        }
        return false;
    }
}
