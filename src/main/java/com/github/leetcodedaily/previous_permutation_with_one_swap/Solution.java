package com.github.leetcodedaily.previous_permutation_with_one_swap;

/**
 * @Author Dooby Kim
 * @Date 2023/4/3 9:57 上午
 * @Version 1.0
 */
public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int r = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[r--] < arr[i]) {
                int j = arr.length - 1;
                while (arr[j] >= arr[i]) {
                    j--;
                }
                while (arr[j] == arr[j - 1]) {
                    j--;
                }
                swap(arr, i, j);
                return arr;
            }
        }
        return arr;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
