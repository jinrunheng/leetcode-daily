package com.github.leetcodedaily.minimum_sum_of_squared_difference;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Dooby Kim
 * @Date 2024/1/19 12:25 上午
 * @Version 1.0
 */
public class Solution {
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        // k = k1 + k2
        // int[] differenceValue
        // 4，4，4，3 从大到小排序, 使用优先级队列
        // 3,3,3,4 贪心---> 每次从最大的开始减
        int k = k1 + k2;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums1.length; i++) {
            maxHeap.add(Math.abs(nums1[i] - nums2[i]));
        }

        while (k > 0) {
            int poll = maxHeap.remove();
            if (poll == 0) {
                maxHeap.add(poll);
            }else {
                maxHeap.add(--poll);
            }
            k--;
        }

        long res = 0L;
        while (!maxHeap.isEmpty()) {
            long poll = maxHeap.remove();
            res += Math.pow(poll, 2);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,10,12};
        int[] nums2 = {5,8,6,9};
        int k1 = 1;
        int k2 = 1;
        System.out.println(minSumSquareDiff(nums1, nums2, k1, k2));
    }
}
