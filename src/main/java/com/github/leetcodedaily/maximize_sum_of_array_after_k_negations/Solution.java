package com.github.leetcodedaily.maximize_sum_of_array_after_k_negations;

import java.util.PriorityQueue;

/**
 * 2021.12.2 每日一题
 * 思路为使用优先级队列（小根堆）
 * 首先将 nums 数组中的元素放入到小根堆中
 * 然后取出堆顶元素取反后再放入到小根堆，迭代 k 次
 * 最后将小根堆所有的元素 poll 出，总和即为最大化的数组和
 */
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 使用一个小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }
        for (int i = 0; i < k; i++) {
            minHeap.offer(-minHeap.poll());
        }
        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        return sum;

    }
}
