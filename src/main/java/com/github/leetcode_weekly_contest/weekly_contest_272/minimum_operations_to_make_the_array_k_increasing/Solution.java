package com.github.leetcode_weekly_contest.weekly_contest_272.minimum_operations_to_make_the_array_k_increasing;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public int kIncreasing(int[] arr, int k) {
        // arr = [4,1,5,5,6,2,1] , k = 3
        // arr[0] arr[3] arr[6]  ===> 4 5 1 ---- 2
        // arr[1] arr[4]  ===> 1 6 ---- 2
        // arr[2] arr[5]  ===> 5 2 ---- 0

        int res = 0;

        for (int i = 0; i < k; i++) {
            List<Integer> tmpList = new ArrayList<>();
            int j = i;
            while (j < arr.length) {
                tmpList.add(arr[j]);
                j += k;
            }
            list.add(tmpList);
        }

        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).size() - getNumberOfLongestSubsequencesInList(list.get(i));
        }
        return res;
    }

    public int getNumberOfLongestSubsequencesInList(List<Integer> list) {
        // 存储递增子序列的元素
        List<Integer> tmp = new ArrayList<>();
        tmp.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int l = 0;
            int r = tmp.size() - 1;
            if (list.get(i) >= tmp.get(r)) {
                tmp.add(list.get(i));
            } else {
                // 二分
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tmp.get(mid) <= list.get(i)) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tmp.set(l, list.get(i));
            }
        }
        return tmp.size();
    }
}
