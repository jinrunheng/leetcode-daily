package com.github.leetcodedaily.find_the_losers_of_the_circular_game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/8/16 3:44 上午
 * @Version 1.0
 * @Link https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
 */
public class Solution {

    public int[] circularGameLosers(int n, int k) {

        Set<Integer> set = new HashSet<>();
        int tmp = 1;
        set.add(tmp);
        int t = 1;
        while (!set.contains((tmp + t * k) % n)) {
            tmp = (tmp + t++ * k) % n;
            if (tmp == 0) {
                if (set.contains(n)) {
                    break;
                }
                set.add(n);
            }else {
                set.add(tmp);
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        // 1 + 1 % 4 = 2
        // 2 + 2 % 4 = 0(4)
        // 4 + 3 % 4 = 3
        //
        final int[] ints = solution.circularGameLosers(4, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
