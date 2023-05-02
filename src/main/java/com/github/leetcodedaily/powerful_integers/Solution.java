package com.github.leetcodedaily.powerful_integers;

import java.util.*;

/**
 * @Author Dooby Kim
 * @Date 2023/5/2 6:03 下午
 * @Version 1.0
 */
public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        if (x == 1 && y == 1) {
            return 2 <= bound ? List.of(2) : Collections.emptyList();
        } else if (x == 1) {
            while (1 + Math.pow(y, j) <= bound) {
                set.add((int) (1 + Math.pow(y, j++)));
            }
        } else if (y == 1) {
            while (Math.pow(x, i) + 1 <= bound) {
                set.add((int) (Math.pow(x, i++) + 1));
            }
        } else {
            while (Math.pow(x, i) + Math.pow(y, j) <= bound) {
                while (Math.pow(x, i) + Math.pow(y, j) <= bound) {
                    set.add((int) (Math.pow(x, i) + Math.pow(y, j)));
                    j++;
                }
                j = 0;
                i++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 1;
        int bound = 10;
        Solution solution = new Solution();
        System.out.println(solution.powerfulIntegers(x, y, bound));
    }
}
