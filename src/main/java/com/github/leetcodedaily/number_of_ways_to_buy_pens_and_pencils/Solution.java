package com.github.leetcodedaily.number_of_ways_to_buy_pens_and_pencils;

/**
 * @Author Dooby Kim
 * @Date 2023/9/1 10:02 上午
 * @Version 1.0
 * @Link https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/
 */
public class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int t1 = 0;
        while (t1 * cost1 <= total) {
                res++;
                res += (total - t1 * cost1) / cost2;

            t1++;
        }
        return res;
    }

    public static void main(String[] args) {
        int total = 5;
        int cost1 = 10;
        int cost2 = 10;
        Solution solution = new Solution();
        final long l = solution.waysToBuyPensPencils(total, cost1, cost2);
        System.out.println(l);
    }
}
