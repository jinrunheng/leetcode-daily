package com.github.leetcodedaily.mice_and_cheese;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Dooby Kim
 * @Date 2023/6/7 10:17 上午
 * @Version 1.0
 */
public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // 最大差值
        // reward1 = [1,1,3,4]
        // reward2 = [4,4,1,1]
        // 假如所有的奶酪都先让第二只老鼠吃掉，那么该问题就变成了，从第二只老鼠那里分出 k 个奶酪，让第一只老鼠吃，使得得分最大
        // 每分出一个奶酪，总得分变为 SUM(reward2) + reward1[i] - reward2[i]
        // 使用最大堆
        Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int sum2 = 0;
        for (int i = 0; i < reward1.length; i++) {
            sum2 += reward2[i];
            maxHeap.offer(reward1[i] - reward2[i]);
        }

        for (int i = 0; i < k; i++) {
            int poll = maxHeap.poll();
            sum2 += poll;
        }

        return sum2;
    }
}
