package com.github.leetcode_weekly_contest.weekly_contest_274.destroying_asteroids;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2022/1/2 10:56 上午
 * @Version 1.0
 */
class Solution {
    // 要求为 O(n) 的时间复杂度
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        long m = mass;
//        for (int i = 0; i < asteroids.length; i++) {
//            if (!pq.isEmpty()) {
//                if (m >= pq.peek()) {
//                    m += pq.poll();
//                }
//            }
//            if (m >= asteroids[i]) {
//                m += asteroids[i];
//            } else {
//                pq.add(asteroids[i]);
//            }
//        }
//        return pq.isEmpty() && m != mass;
        Arrays.sort(asteroids);
        long m = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (m >= asteroids[i]) {
                m += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
