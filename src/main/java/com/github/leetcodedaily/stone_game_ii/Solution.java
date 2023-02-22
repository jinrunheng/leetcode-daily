package com.github.leetcodedaily.stone_game_ii;

/**
 * @Author Dooby Kim
 * @Date 2023/2/22 6:16 下午
 * @Version 1.0
 */
public class Solution {
    /**
     * 动太规划：
     * 其中 dp[i][j] 表示：剩余 [i~len-1] 堆时，M = j 的情况下，先取的人能狗获得的最多的棋子数
     * 本题要从后向前去递推
     * 动态规划方程：
     * if i + 2 * M >= len; dp[i][j] = sum[i~len-1]
     * if i + 2 * M < len; dp[i][j] = max(dp[i][j],sum[i~len-1] - dp[i + x][max(M,x)])
     *
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] piles = new int[]{2, 7, 9, 4, 4};
        Solution solution = new Solution();
        System.out.println(solution.stoneGameII(piles));
    }
}
