package com.github.leetcodedaily.pairs_of_songs_with_total_durations_divisible_by_60;

/**
 * @Author Dooby Kim
 * @Date 2023/5/7 10:45 上午
 * @Version 1.0
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // (time[i] + time[j]) % 60 == 0
        // (time[i] % 60 + time[j] % 60) % 60 == 0

        // 1. time = [30,20,150,100,40]
        // 2. tmp = [30,20,30,40,40]
        // 3. 计数排序
        // 4. 有多少种排列组合的情况
        long res = 0;
        int[] cnt = new int[60];
        for (int t : time) {
            cnt[t % 60]++;
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2;
        res += (long) cnt[30] * (cnt[30] - 1) / 2;
        int i = 1, j = 59;
        while (i < j) {
            res += cnt[i++] * cnt[j--];
        }
        return (int) res;
    }
}
