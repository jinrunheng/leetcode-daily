package com.github.leetcodedaily.minimum_increment_to_make_array_unique;

/**
 * @Author Dooby Kim
 * @Date 2024/1/17 12:30 上午
 * @Version 1.0
 */
public class Solution {
    public static int minIncrementForUnique(int[] nums) {
        // 可以使用桶
        // 0 <= nums[i] <= 10^5
        // 1. 遍历 nums 桶中存放 nums[i] 的个数
        // bucket =  [0,1,2,3,4,5,6,7,...]
        // bucket =  [0,2,2,1,0,0,0,1]
        // 1. sort
        // 1，1，2，2，3，7
        // 1，2，3，4，5，6
        int[] bucket = new int[200000];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        int index0 = 0;
        int cur = 0;
        int res = 0;
        while (cur < bucket.length) {
            while (bucket[cur] >= 2) {
                while (index0 <= cur || bucket[index0] != 0) {
                    index0++;
                }
                res += index0 - cur;
                bucket[index0]++;
                bucket[cur]--;
            }
            cur++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7};
        final int i = minIncrementForUnique(nums);
        System.out.println(i);
    }
}
