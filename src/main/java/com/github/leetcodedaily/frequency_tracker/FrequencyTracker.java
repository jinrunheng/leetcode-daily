package com.github.leetcodedaily.frequency_tracker;

/**
 * @Author Dooby Kim
 * @Date 2024/3/22 上午12:20
 * @Version 1.0
 */
public class FrequencyTracker {
    // 记录每个 num 出现的频率
    private int[] freq;
    // 记录每个频率出现的次数
    private int[] freqCount;

    public FrequencyTracker() {
        freq = new int[100001];
        freqCount = new int[100001];
    }

    public void add(int number) {
        freqCount[freq[number]]--;
        freq[number]++;
        freqCount[freq[number]]++;
    }

    public void deleteOne(int number) {
        if (freq[number] == 0) {
            return;
        }
        freqCount[freq[number]]--;
        freq[number]--;
        freqCount[freq[number]]++;
    }

    public boolean hasFrequency(int frequency) {
        return freqCount[frequency] > 0;
    }
}
