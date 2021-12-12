package com.github.leetcode_weekly_contest.weekly_contest_271.watering_plants_ii;

class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int p1 = 0;
        int p2 = plants.length - 1;
        int initCapacityA = capacityA;
        int initCapacityB = capacityB;

        while (p1 < p2) {
            if (capacityA < plants[p1]) {
                capacityA = initCapacityA;
                res++;
            }
            capacityA -= plants[p1++];

            if (capacityB < plants[p2]) {
                capacityB = initCapacityB;
                res++;
            }
            capacityB -= plants[p2--];

        }
        if (p1 == p2 && capacityA < plants[p1] && capacityB < plants[p2]) {
            return res + 1;
        }
        return res;
    }
}
