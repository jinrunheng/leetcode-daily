package com.github.leetcodedaily.compare_strings_by_frequency_of_the_smallest_character;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/6/10 11:06 上午
 * @Version 1.0
 */
public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        Integer[] queriesNum = new Integer[queries.length];
        Integer[] wordsNum = new Integer[words.length];
        for (int i = 0; i < queries.length; i++) {
            queriesNum[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wordsNum[i] = f(words[i]);
        }

        Arrays.sort(wordsNum, (o1, o2) -> o2 - o1);

        for (int i = 0; i < queriesNum.length; i++) {
            int q = queriesNum[i];
            int r = 0;
            for (int j = 0; j < wordsNum.length; j++) {
                if (wordsNum[j] > q) {
                    r++;
                } else {
                    break;
                }
            }
            res[i] = r;
        }
        return res;
    }

    private int f(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return arr[i];
            }
        }
        return -1;
    }
}
