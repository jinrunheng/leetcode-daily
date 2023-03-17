package com.github.leetcodedaily.longest_subsequence_with_limited_sum;

import java.util.Arrays;

/**
 * @Author Dooby Kim
 * @Date 2023/3/17 12:19 下午
 * @Version 1.0
 */
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = find(prefix, queries[i]);
        }
        return res;
    }

    private int find(int[] arr, int target) {
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] > target) {
            return l - 1;
        } else {
            return l;
        }
    }
}
