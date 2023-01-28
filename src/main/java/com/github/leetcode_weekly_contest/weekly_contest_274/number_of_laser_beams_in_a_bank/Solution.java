package com.github.leetcode_weekly_contest.weekly_contest_274.number_of_laser_beams_in_a_bank;

/**
 * @Author Dooby Kim
 * @Date 2022/1/2 10:41 上午
 * @Version 1.0
 */
class Solution {

    private String[] bank;

    public int numberOfBeams(String[] bank) {
        this.bank = bank;
        int res = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 0; i < this.bank.length; i++) {
            if (numberOfLaserEquipmentsInRow(i) != 0) {
                if (tmp1 != 0)
                    tmp2 = numberOfLaserEquipmentsInRow(i);
                else
                    tmp1 = numberOfLaserEquipmentsInRow(i);

                if (tmp1 != 0 && tmp2 != 0) {
                    res += tmp1 * tmp2;
                    tmp1 = tmp2;
                }
            }
        }
        return res;
    }

    private int numberOfLaserEquipmentsInRow(int row) {
        String line = bank[row];
        int res = 0;
        for (int i = 0; i < line.length(); i++)
            if (line.charAt(i) == '1') res++;
        return res;
    }

    public static void main(String[] args) {
        String[] bank = {"011001", "000000", "010100", "001000"};
        Solution solution = new Solution();
        int i = solution.numberOfBeams(bank);
        System.out.println(i);
    }
}
