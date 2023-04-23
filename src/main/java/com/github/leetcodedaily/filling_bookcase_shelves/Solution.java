package com.github.leetcodedaily.filling_bookcase_shelves;

/**
 * @Author Dooby Kim
 * @Date 2023/4/23 8:29 下午
 * @Version 1.0
 */
public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        dp[0] = 0;
        for (int i = 0; i < books.length; i++) {
            int min = Integer.MAX_VALUE;
            int curWidth = 0;
            int curMaxHeight = books[i][1];
            for (int j = i; j >= 0; j--) {
                curMaxHeight = Math.max(curMaxHeight, books[j][1]);
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                min = Math.min(min, dp[j] + curMaxHeight);
            }
            dp[i + 1] = min;
        }
        return dp[books.length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] books = new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        System.out.println(solution.minHeightShelves(books, shelfWidth));
    }
}
