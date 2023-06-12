package com.github.leetcodedaily.number_of_unequal_triplets_in_array;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/6/13 5:20 上午
 * @Version 1.0
 */
public class Solution {
    public int unequalTriplets(int[] nums) {
        // 通过分析可知，排序对本题结果并无影响
        Arrays.sort(nums);
        int res = 0;
        final int len = nums.length;
        for (int i = 0, j = 0; i < len; i = j) {
            while (j < len && nums[i] == nums[j]) {
                j++;
            }
            // 三元组的个数
            // 譬如：
            // 222334444
            // 其可以看作：222 33 4444
            // 三元组的数目为 3 * 2 * 4
            // i * (j - i) * (len - j) 的含义为
            // j - i 表示三元组中间的数字的个数，i 表示中间数字左边的数的个数，len - j 表示中间数字右边的数的个数
            res += i * (j - i) * (len - j);
        }
        return res;
    }
}
