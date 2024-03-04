package com.github.leetcodedaily.minimum_operations_to_exceed_threshold_value_ii;

import java.util.PriorityQueue;

/**
 * @Author Dooby Kim
 * @Date 2024/3/4 下午10:11
 * @Version 1.0
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer((long) num);
        }
        int res = 0;
        while (!minHeap.isEmpty() && minHeap.size() >= 2) {
            if (minHeap.peek() >= k) {
                break;
            } else {
                long x = minHeap.poll();
                long y = minHeap.poll();
                long combined = Math.min(x, y) * 2 + Math.max(x, y);
                minHeap.offer(combined);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999};
        int k = 1000000000;
        Solution solution = new Solution();
        final int i = solution.minOperations(nums, k);
        System.out.println(i);
    }
}
