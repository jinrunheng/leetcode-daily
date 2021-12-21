package com.github.leetcodedaily.day_of_the_year;

/**
 * @Author Dooby Kim
 * @Date 2021/12/21 9:22 上午
 * @Version 1.0
 */
class Solution {

    private static final int[] nonLeapYear = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] leapYear = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int y = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);

        int res = 0;

        boolean isLeapYear = isLeapYear(y);

        for (int i = 0; i < m - 1; i++) {
            if (isLeapYear) {
                res += leapYear[i];
            } else {
                res += nonLeapYear[i];
            }
        }

        return res + d;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 || year % 400 == 0;
    }

    public static void main(String[] args) {
        String date = "2003-03-01";
        Solution solution = new Solution();
        solution.dayOfYear(date);
    }
}
